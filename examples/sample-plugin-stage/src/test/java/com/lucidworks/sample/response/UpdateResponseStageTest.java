package com.lucidworks.sample.response;

import com.lucidworks.querying.api.DslQueryRequest;
import com.lucidworks.querying.api.DslQueryRequestResponse;
import com.lucidworks.querying.api.DslQueryResponse;
import com.lucidworks.querying.sdk.test.QueryStageTestBase;
import com.lucidworks.querying.sdk.test.TestDslQueryRequest;
import com.lucidworks.querying.sdk.test.TestDslQueryResponse;
import com.lucidworks.search.dsl.response.DocList;
import com.lucidworks.search.dsl.response.ResponseDocument;
import com.lucidworks.search.dsl.response.Results;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class UpdateResponseStageTest extends QueryStageTestBase<UpdateResponseStageConfig> {

    @Test
    public void testProcess() throws ReflectiveOperationException {
        UpdateResponseStageConfig stageConfig = newConfig(UpdateResponseStageConfig.class, config -> {
            when(config.field()).thenReturn("field");
            when(config.value()).thenReturn("value");
        });

        DslQueryRequest queryRequest = new TestDslQueryRequest();
        DslQueryResponse queryResponse = new TestDslQueryResponse();

        List<ResponseDocument> docs = new ArrayList<>();
        docs.add(new ResponseDocument(
                "collection", "type", "some-id", 0.4, null, null, null, null));

        queryResponse.setResults(new Results(new DocList(1L, 0.0, docs, null), null));

        Map<String, Object> fields = new HashMap<>();
        fields.put("field", "value");
        ResponseDocument document = new ResponseDocument(
                "collection", "type", "some-id", 0.4, fields, null, null, null);
        queryResponse.getResults().getList().setDocs(Collections.singletonList(document));

        DslQueryRequestResponse queryRequestResponse = newDslQueryRequestResponse(queryRequest, queryResponse);

        UpdateResponseStage stage = createStage(UpdateResponseStage.class, stageConfig);
        final DslQueryRequestResponse processedQRR = stage.process(queryRequestResponse, null);

        assertTrue(processedQRR.getDslQueryResponse().getResults().getList().getDocs().get(0).getFields().containsKey("field"));
        assertEquals("value", processedQRR.getDslQueryResponse().getResults().getList().getDocs().get(0).getFields().get("field"));
    }
}
