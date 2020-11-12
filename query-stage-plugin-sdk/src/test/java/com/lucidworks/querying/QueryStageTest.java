package com.lucidworks.querying;

import com.lucidworks.fusion.schema.SchemaAnnotations;
import com.lucidworks.querying.api.Context;
import com.lucidworks.querying.api.QueryRequestAndResponse;
import com.lucidworks.querying.api.QueryStageBase;
import com.lucidworks.querying.api.Request;
import com.lucidworks.querying.api.Stage;
import com.lucidworks.querying.api.fusion.Fusion;
import com.lucidworks.querying.config.QueryStageConfig;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QueryStageTest {

    @Test
    public void testSampleIndexStage() {
        TestStageConfig config = mock(TestStageConfig.class);
        when(config.timeAllowed()).thenReturn("5000");
        Fusion fusion = mock(Fusion.class);

        QueryRequestAndResponse query = mock(QueryRequestAndResponse.class);
        Request request = mock(Request.class);
        when(query.getRequest()).thenReturn(request);

        Context context = mock(Context.class);

        TestStage stage = new TestStage();
        stage.init(config, fusion);
        final QueryRequestAndResponse processedQuery = stage.process(query, context);

        verify(query, times(1)).getRequest();
        verify(request, times(1)).addQueryParam(anyString(), anyString());
    }

    @SchemaAnnotations.RootSchema(title = "Test", description = "Test stage.")
    static interface TestStageConfig extends QueryStageConfig {

        @SchemaAnnotations.Property
        @SchemaAnnotations.StringSchema
        String timeAllowed();
    }

    @Stage(type = "test-stage", configClass = TestStageConfig.class)
    static class TestStage extends QueryStageBase<TestStageConfig> {

        @Override
        public QueryRequestAndResponse process(QueryRequestAndResponse query, Context context) {
            query.getRequest().addQueryParam("timeAllowed", config.timeAllowed());
            return query;
        }
    }
}
