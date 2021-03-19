package com.lucidworks.sample.legacy;

import com.lucidworks.querying.api.Context;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryStageBase;
import com.lucidworks.querying.api.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stage(type = "legacy-update-request", configClass = LegacyUpdateRequestStageConfig.class)
public class LegacyUpdateRequestStage extends QueryStageBase<LegacyUpdateRequestStageConfig> {

    private static final Logger logger = LoggerFactory.getLogger(LegacyUpdateRequestStage.class);

    @Override
    public QueryRequestResponse process(QueryRequestResponse queryRequestResponse, Context context) {
        queryRequestResponse.getQueryRequest().setParam(config.queryParam(), config.value());
        return queryRequestResponse;
    }
}
