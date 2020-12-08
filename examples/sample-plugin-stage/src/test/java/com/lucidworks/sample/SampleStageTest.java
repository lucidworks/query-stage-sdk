package com.lucidworks.sample;

import com.lucidworks.indexing.sdk.test.QueryStageTestBase;
import com.lucidworks.indexing.sdk.test.TestQueryRequest;
import com.lucidworks.indexing.sdk.test.TestQueryResponse;
import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class SampleStageTest extends QueryStageTestBase<SampleStageConfig> {

    @Test
    public void testProcess() throws ReflectiveOperationException {
        SampleStageConfig stageConfig = newConfig(SampleStageConfig.class, config -> {
            when(config.queryParam()).thenReturn("timeout");
            when(config.value()).thenReturn("5000");
        });

        QueryRequest queryRequest = new TestQueryRequest();
        QueryResponse queryResponse = new TestQueryResponse();

        QueryRequestResponse queryRequestResponse = newQueryRequestAndResponse(queryRequest, queryResponse);

        SampleStage stage = createStage(SampleStage.class, stageConfig);
        final QueryRequestResponse processedQRR = stage.process(queryRequestResponse, null);

        assertTrue(processedQRR.getQueryRequest().hasQueryParam("timeout"));
        assertTrue(processedQRR.getQueryRequest().getQueryParam("timeout").contains("5000"));
    }
}
