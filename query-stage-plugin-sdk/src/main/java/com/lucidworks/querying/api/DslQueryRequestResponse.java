package com.lucidworks.querying.api;

/**
 * Fusion query request and response. {@link DslQueryRequestResponse} instance is an input of a query pipeline stage.
 */
public interface DslQueryRequestResponse {

    DslQueryRequest getDslQueryRequest();

    DslQueryResponse getDslQueryResponse();
}
