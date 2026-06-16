package com.lucidworks.sample.response;

import com.lucidworks.querying.api.Context;
import com.lucidworks.querying.api.Document;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryStageBase;
import com.lucidworks.querying.api.Stage;

import java.util.List;

@Stage(type = "update-response", configClass = UpdateResponseStageConfig.class)
public class UpdateResponseStage extends QueryStageBase<UpdateResponseStageConfig> {

    @Override
    public QueryRequestResponse process(QueryRequestResponse queryRequestResponse, Context context) {
        queryRequestResponse.getQueryResponse().ifPresent(queryResponse -> {
            final List<Document> documents = queryResponse.getDocuments();
            documents.forEach(document -> document.setField(config.field(), config.value()));
            queryResponse.updateDocuments(documents);
        });

        return queryRequestResponse;
    }
}
