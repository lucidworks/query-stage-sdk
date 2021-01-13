package com.lucidworks.querying;

import com.lucidworks.fusion.schema.SchemaAnnotations.Property;
import com.lucidworks.fusion.schema.SchemaAnnotations.RootSchema;
import com.lucidworks.fusion.schema.SchemaAnnotations.StringSchema;
import com.lucidworks.querying.api.Context;
import com.lucidworks.querying.api.DslQueryRequestResponse;
import com.lucidworks.querying.api.QueryStageBase;
import com.lucidworks.querying.api.Stage;
import com.lucidworks.querying.api.fusion.Fusion;
import com.lucidworks.querying.config.QueryStageConfig;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QueryStageTest {

    @Test
    public void testSampleIndexStage() {
        TestStageConfig config = mock(TestStageConfig.class);
        when(config.timeAllowed()).thenReturn("5000");
        Fusion fusion = mock(Fusion.class);

        DslQueryRequestResponse query = new MockDslQueryRequestResponse();
        Context context = mock(Context.class);

        TestStage stage = new TestStage();
        stage.init(config, fusion);
        final DslQueryRequestResponse processedQuery = stage.process(query, context);

        assertTrue(processedQuery.getDslQueryRequest().getParams().containsKey("timeAllowed"));
    }

    @RootSchema(title = "Test", description = "Test stage.")
    interface TestStageConfig extends QueryStageConfig {

        @Property
        @StringSchema
        String timeAllowed();
    }

    @Stage(type = "test-stage", configClass = TestStageConfig.class)
    static class TestStage extends QueryStageBase<TestStageConfig> {

        @Override
        public DslQueryRequestResponse process(DslQueryRequestResponse query, Context context) {
            query.getDslQueryRequest().getParams().put("timeAllowed", config.timeAllowed());
            return query;
        }
    }
}
