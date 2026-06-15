package com.lucidworks.sample.response;

import com.lucidworks.querying.api.Document;
import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;
import com.lucidworks.querying.sdk.test.QueryStageTestBase;
import com.lucidworks.querying.sdk.test.TestQueryRequest;
import com.lucidworks.querying.sdk.test.TestQueryResponse;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UpdateResponseStageTest extends QueryStageTestBase<UpdateResponseStageConfig> {

    @Test
    public void testProcess() throws ReflectiveOperationException {
        UpdateResponseStageConfig stageConfig = newConfig(UpdateResponseStageConfig.class, config -> {
            when(config.field()).thenReturn("field");
            when(config.value()).thenReturn("value");
        });

        QueryRequest queryRequest = new TestQueryRequest();
        TestQueryResponse queryResponse = new TestQueryResponse();

        Map<String, Object> docFields = new HashMap<>();
        Document document = mock(Document.class);
        when(document.setField(org.mockito.ArgumentMatchers.anyString(), org.mockito.ArgumentMatchers.any()))
                .thenAnswer(invocation -> {
                    docFields.put(invocation.getArgument(0), invocation.getArgument(1));
                    return null;
                });
        when(document.containsField(org.mockito.ArgumentMatchers.anyString()))
                .thenAnswer(invocation -> docFields.containsKey(invocation.getArgument(0)));

        queryResponse.updateDocuments(Collections.singletonList(document));

        QueryRequestResponse queryRequestResponse = newQueryRequestResponse(queryRequest, queryResponse);

        UpdateResponseStage stage = createStage(UpdateResponseStage.class, stageConfig);
        final QueryRequestResponse processedQRR = stage.process(queryRequestResponse, null);

        Document processedDoc = processedQRR.getQueryResponse().get().getDocuments().get(0);
        assertTrue(processedDoc.containsField("field"));
        assertEquals("value", docFields.get("field"));
    }
}
