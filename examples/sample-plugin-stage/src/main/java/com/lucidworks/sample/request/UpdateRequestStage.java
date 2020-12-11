package com.lucidworks.sample.request;

import com.lucidworks.querying.api.Context;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryStageBase;
import com.lucidworks.querying.api.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

@Stage(type = "update-request", configClass = UpdateRequestStageConfig.class)
public class UpdateRequestStage extends QueryStageBase<UpdateRequestStageConfig> {

    private static final Logger logger = LoggerFactory.getLogger(UpdateRequestStage.class);

    @Override
    public QueryRequestResponse process(QueryRequestResponse queryRequestResponse, Context context) {
      queryRequestResponse.getQueryRequest().setQueryParam(config.queryParam(), config.value());
      return queryRequestResponse;
    }

    @Override
    public void process(QueryRequestResponse queryRequestResponse, Context context, Consumer<QueryRequestResponse> output) {
        logger.info("Simple Stage emitting queryRequestResponse with query params: {}", queryRequestResponse.getQueryRequest().getQueryParams());

        output.accept(process(queryRequestResponse, context));
    }
}
