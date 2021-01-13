package com.lucidworks.sample.request;

import com.lucidworks.querying.api.DslQueryRequest;
import com.lucidworks.querying.api.DslQueryResponse;
import com.lucidworks.querying.api.DslQueryRequestResponse;
import com.lucidworks.querying.sdk.test.QueryStageTestBase;
import com.lucidworks.querying.sdk.test.TestDslQueryRequest;
import com.lucidworks.querying.sdk.test.TestDslQueryResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class UpdateRequestStageTest extends QueryStageTestBase<UpdateRequestStageConfig> {

    @Test
    public void testProcess() throws ReflectiveOperationException {
        UpdateRequestStageConfig stageConfig = newConfig(UpdateRequestStageConfig.class, config -> {
            when(config.queryParam()).thenReturn("timeout");
            when(config.value()).thenReturn("5000");
        });

        DslQueryRequest queryRequest = new TestDslQueryRequest();
        DslQueryResponse queryResponse = new TestDslQueryResponse();

        DslQueryRequestResponse queryRequestResponse = newDslQueryRequestResponse(queryRequest, queryResponse);

        UpdateRequestStage stage = createStage(UpdateRequestStage.class, stageConfig);
        final DslQueryRequestResponse processedQRR = stage.process(queryRequestResponse, null);

        assertTrue(processedQRR.getDslQueryRequest().getParams().containsKey("timeout"));
        assertEquals("5000", processedQRR.getDslQueryRequest().getParams().get("timeout"));
    }
}
