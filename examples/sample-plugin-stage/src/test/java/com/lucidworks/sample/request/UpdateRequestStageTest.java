package com.lucidworks.sample.request;

import com.lucidworks.indexing.sdk.test.QueryStageTestBase;
import com.lucidworks.indexing.sdk.test.TestQueryRequest;
import com.lucidworks.indexing.sdk.test.TestQueryResponse;
import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class UpdateRequestStageTest extends QueryStageTestBase<UpdateRequestStageConfig> {

    @Test
    public void testProcess() throws ReflectiveOperationException {
        UpdateRequestStageConfig stageConfig = newConfig(UpdateRequestStageConfig.class, config -> {
            when(config.queryParam()).thenReturn("timeout");
            when(config.value()).thenReturn("5000");
        });

        QueryRequest queryRequest = new TestQueryRequest();
        QueryResponse queryResponse = new TestQueryResponse();

        QueryRequestResponse queryRequestResponse = newQueryRequestAndResponse(queryRequest, queryResponse);

        UpdateRequestStage stage = createStage(UpdateRequestStage.class, stageConfig);
        final QueryRequestResponse processedQRR = stage.process(queryRequestResponse, null);

        assertTrue(processedQRR.getQueryRequest().hasQueryParam("timeout"));
        assertTrue(processedQRR.getQueryRequest().getQueryParam("timeout").contains("5000"));
    }
}
