package com.lucidworks.querying;

import com.lucidworks.querying.api.DslQueryRequest;
import com.lucidworks.querying.api.DslQueryResponse;
import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MockQueryRequestResponse implements QueryRequestResponse {

    private final Map<String, Collection<String>> headers = new HashMap<>();

    private final Map<String, Collection<String>> queryParams = new HashMap<>();

    @Override
    public QueryRequest getQueryRequest() {
        return new QueryRequest() {
            @Override
            public String getHttpMethod() {
                return "GET";
            }

            @Override
            public Map<String, Collection<String>> getHeaders() {
                return headers;
            }

            @Override
            public Map<String, Collection<String>> getQueryParams() {
                return queryParams;
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
                if (!hasQueryParam(queryParam)) {
                    setQueryParam(queryParam, value);
                } else {
                    getQueryParam(queryParam).add(value);
                }
            }

            @Override
            public void setQueryParam(String queryParam, String value) {
                queryParams.put(queryParam, Arrays.asList(value));
            }

            @Override
            public void removeQueryParam(String queryParam) {
                queryParams.remove(queryParam);
            }

            @Override
            public void clearQueryParams() {
                queryParams.clear();
            }
        };
    }

    @Override
    public Optional<QueryResponse> getQueryResponse() {
        return Optional.empty();
    }

    @Override
    public DslQueryRequest getDslQueryRequest() {
        return null;
    }

    @Override
    public DslQueryResponse getDslQueryResponse() {
        return null;
    }
}
