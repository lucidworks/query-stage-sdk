package com.lucidworks.querying.api;

import java.util.Optional;

/**
 * Fusion query request and response. {@link QueryRequestResponse} instance is an input of a query pipeline stage.
 */
public interface QueryRequestResponse {

    QueryRequest getQueryRequest();

    Optional<QueryResponse> getQueryResponse();

    DslQueryRequest getDslQueryRequest();

    DslQueryResponse getDslQueryResponse();
}
