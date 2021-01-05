package com.lucidworks.sample.response;

import com.lucidworks.querying.api.Context;
import com.lucidworks.querying.api.DslQueryRequestResponse;
import com.lucidworks.querying.api.QueryStageBase;
import com.lucidworks.querying.api.Stage;
import com.lucidworks.search.dsl.response.ResponseDocument;
import com.lucidworks.search.dsl.response.Results;

import java.util.List;

@Stage(type = "update-response", configClass = UpdateResponseStageConfig.class)
public class UpdateResponseStage extends QueryStageBase<UpdateResponseStageConfig> {

    @Override
    public DslQueryRequestResponse process(DslQueryRequestResponse dslQueryRequestResponse, Context context) {
        final Results results = dslQueryRequestResponse.getDslQueryResponse().getResults();
        final List<ResponseDocument> docs = results.getList().getDocs();
        docs.forEach(responseDocument -> responseDocument.getFields().put(config.field(), config.value()));
        results.getList().setDocs(docs);

        return dslQueryRequestResponse;
    }
}
