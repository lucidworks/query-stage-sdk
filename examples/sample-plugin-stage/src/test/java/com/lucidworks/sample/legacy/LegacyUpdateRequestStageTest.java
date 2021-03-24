package com.lucidworks.sample.legacy;

import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;
import com.lucidworks.querying.sdk.test.QueryStageTestBase;
import com.lucidworks.querying.sdk.test.TestQueryRequest;
import com.lucidworks.querying.sdk.test.TestQueryResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LegacyUpdateRequestStageTest extends QueryStageTestBase<LegacyUpdateRequestStageConfig> {

  @Test
  public void testProcess() throws ReflectiveOperationException {
    LegacyUpdateRequestStageConfig stageConfig = newConfig(LegacyUpdateRequestStageConfig.class, config -> {
      when(config.queryParam()).thenReturn("timeout");
      when(config.value()).thenReturn("5000");
    });

    QueryRequest queryRequest = new TestQueryRequest();
    QueryResponse queryResponse = new TestQueryResponse();

    QueryRequestResponse queryRequestResponse = newQueryRequestResponse(queryRequest, queryResponse);

    LegacyUpdateRequestStage stage = createStage(LegacyUpdateRequestStage.class, stageConfig);
    final QueryRequestResponse processedQRR = stage.process(queryRequestResponse, null);

    assertTrue(processedQRR.getQueryRequest().hasParam("timeout"));
    assertEquals("5000", processedQRR.getQueryRequest().getFirstParam("timeout"));
  }

}