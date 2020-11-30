package com.lucidworks.indexing.sdk.test;

import com.lucidworks.querying.api.QueryRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestQueryRequest implements QueryRequest {

    private final Map<String, Collection<String>> queryParams = new HashMap<>();

    private final Map<String, Collection<String>> headers = new HashMap<>();

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public Map<String, Collection<String>> getQueryParams() {
        return queryParams;
    }

    @Override
    public Map<String, Collection<String>> getHeaders() {
        return headers;
    }

    @Override
    public boolean hasQueryParam(String queryParam) {
        return queryParams.containsKey(queryParam);
    }

    @Override
    public Collection<String> getQueryParam(String queryParam) {
        return queryParams.get(queryParam);
    }

    @Override
    public void addQueryParam(String queryParam, String value) {
        final Collection<String> values = queryParams.get(queryParam);
        if (values != null) {
            values.add(value);
        } else {
            Collection<String> collection = new ArrayList<>();
            collection.add(value);
            queryParams.put(queryParam, collection);
        }
    }

    @Override
    public void setQueryParam(String queryParam, String value) {
        Collection<String> collection = new ArrayList<>();
        collection.add(value);
        queryParams.put(queryParam, collection);
    }

    @Override
    public void removeQueryParam(String queryParam) {
        queryParams.remove(queryParam);
    }

    @Override
    public void clearQueryParams() {
        queryParams.clear();
    }
}
