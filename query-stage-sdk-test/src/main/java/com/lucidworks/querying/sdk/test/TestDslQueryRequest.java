package com.lucidworks.querying.sdk.test;

import com.lucidworks.querying.api.DslQueryRequest;
import com.lucidworks.search.dsl.request.Facets;
import com.lucidworks.search.dsl.request.Results;
import com.lucidworks.search.dsl.request.query.QueryDefinition;

import java.util.HashMap;
import java.util.Map;

public class TestDslQueryRequest implements DslQueryRequest {

    private QueryDefinition queryDefinition;

    private final Map<String, Object> params = new HashMap<>();

    private Results results;

    private Facets facets;

    @Override
    public QueryDefinition getQueryDefinition() {
        return queryDefinition;
    }

    @Override
    public void setQueryDefinition(QueryDefinition queryDefinition) {
        this.queryDefinition = queryDefinition;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public Results getResults() {
        return results;
    }

    @Override
    public Facets getFacets() {
        return facets;
    }

    @Override
    public void setFacets(Facets facets) {
        this.facets = facets;
    }

    @Override
    public Map<String, Object> getContext() {
        return null;
    }
}
