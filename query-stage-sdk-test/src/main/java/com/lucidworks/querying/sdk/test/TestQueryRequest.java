package com.lucidworks.querying.sdk.test;

import com.lucidworks.querying.api.QueryRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestQueryRequest implements QueryRequest {

    private final Map<String, Collection<String>> queryParams = new HashMap<>();

    private final Map<String, Collection<String>> headers = new HashMap<>();

    @Override
    public String getHttpMethod() {
        return "GET";
    }

    @Override
    public Map<String, Collection<String>> getParams() {
        return queryParams;
    }

    @Override
    public Map<String, Collection<String>> getHeaders() {
        return headers;
    }

    @Override
    public boolean hasParam(String queryParam) {
        return queryParams.containsKey(queryParam);
    }

    @Override
    public Collection<String> getParam(String queryParam) {
        return queryParams.get(queryParam);
    }

    @Override
    public String getFirstParam(String param) {
        return Optional.ofNullable(queryParams.get(param))
            .map(col -> col.isEmpty() ? null : col.iterator().next())
            .orElse(null);
    }

    @Override
    public void addParam(String queryParam, String value) {
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
    public void setParam(String queryParam, String value) {
        Collection<String> collection = new ArrayList<>();
        collection.add(value);
        queryParams.put(queryParam, collection);
    }

    @Override
    public void removeParam(String queryParam) {
        queryParams.remove(queryParam);
    }

    @Override
    public void clearParams() {
        queryParams.clear();
    }
}
