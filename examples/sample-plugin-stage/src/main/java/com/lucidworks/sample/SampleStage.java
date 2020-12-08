package com.lucidworks.sample;

import com.lucidworks.querying.api.Context;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryStageBase;
import com.lucidworks.querying.api.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

@Stage(type = "sample", configClass = SampleStageConfig.class)
public class SampleStage extends QueryStageBase<SampleStageConfig> {

    private static final Logger logger = LoggerFactory.getLogger(SampleStage.class);

    @Override
    public QueryRequestResponse process(QueryRequestResponse queryRequestResponse, Context context) {
      queryRequestResponse.getQueryRequest().setQueryParam(config.queryParam(), config.value());
      return queryRequestResponse;
    }

    @Override
    public void process(QueryRequestResponse queryRequestResponse, Context context, Consumer<QueryRequestResponse> output) {
        logger.info("Sample Stage emitting queryRequestResponse with query params: {}", queryRequestResponse.getQueryRequest().getQueryParams());

        output.accept(process(queryRequestResponse, context));
    }
}
