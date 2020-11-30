package com.lucidworks.querying;

import com.lucidworks.fusion.schema.SchemaAnnotations.Property;
import com.lucidworks.fusion.schema.SchemaAnnotations.RootSchema;
import com.lucidworks.fusion.schema.SchemaAnnotations.StringSchema;
import com.lucidworks.querying.api.Context;
import com.lucidworks.querying.api.QueryRequestResponse;
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

        QueryRequestResponse query = new MockQueryRequestResponse();
        Context context = mock(Context.class);

        TestStage stage = new TestStage();
        stage.init(config, fusion);
        final QueryRequestResponse processedQuery = stage.process(query, context);

        assertTrue(processedQuery.getQueryRequest().hasQueryParam("timeAllowed"));
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
        public QueryRequestResponse process(QueryRequestResponse query, Context context) {
            query.getQueryRequest().addQueryParam("timeAllowed", config.timeAllowed());
            return query;
        }
    }
}
