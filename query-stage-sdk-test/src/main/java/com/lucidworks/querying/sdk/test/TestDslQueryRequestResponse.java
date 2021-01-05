package com.lucidworks.querying.sdk.test;

import com.lucidworks.querying.api.DslQueryRequest;
import com.lucidworks.querying.api.DslQueryRequestResponse;
import com.lucidworks.querying.api.DslQueryResponse;

public class TestDslQueryRequestResponse implements DslQueryRequestResponse {

    private final DslQueryRequest dslQueryRequest;
    private final DslQueryResponse dslQueryResponse;

    public TestDslQueryRequestResponse(DslQueryRequest dslQueryRequest, DslQueryResponse dslQueryResponse) {
        this.dslQueryRequest = dslQueryRequest;
        this.dslQueryResponse = dslQueryResponse;
    }

    @Override
    public DslQueryRequest getDslQueryRequest() {
        return dslQueryRequest;
    }

    @Override
    public DslQueryResponse getDslQueryResponse() {
        return dslQueryResponse;
    }
}
