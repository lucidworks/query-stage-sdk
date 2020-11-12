package com.lucidworks.querying.api;

/**
 * Fusion query request and response. {@link QueryRequestAndResponse} instance is an input of a query pipeline stage.
 */
public interface QueryRequestAndResponse {

    Request getRequest();

    Response getResponse();
}
