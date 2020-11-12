package com.lucidworks.indexing.sdk.test;

import com.lucidworks.querying.api.QueryRequestAndResponse;
import com.lucidworks.querying.api.Request;
import com.lucidworks.querying.api.Response;

public class TestQueryRequestAndResponse implements QueryRequestAndResponse {

    private final Request request;
    private final Response response;

    public TestQueryRequestAndResponse(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public Request getRequest() {
        return request;
    }

    @Override
    public Response getResponse() {
        return response;
    }
}
