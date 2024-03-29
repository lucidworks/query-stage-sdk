package com.lucidworks.querying.sdk.test;

import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;

import java.util.Optional;

public class TestQueryRequestResponse implements QueryRequestResponse {

    private final QueryRequest queryRequest;
    private final QueryResponse queryResponse;

    public TestQueryRequestResponse(QueryRequest queryRequest, QueryResponse queryResponse) {
        this.queryRequest = queryRequest;
        this.queryResponse = queryResponse;
    }

    @Override
    public QueryRequest getQueryRequest() {
        return queryRequest;
    }

    @Override
    public Optional<QueryResponse> getQueryResponse() {
        return Optional.ofNullable(queryResponse);
    }

}
