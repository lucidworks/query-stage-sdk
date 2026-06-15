package com.lucidworks.querying;

import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MockQueryRequestResponse implements QueryRequestResponse {

    private QueryRequest queryRequest;
    private QueryResponse queryResponse;

    @Override
    public QueryRequest getQueryRequest() {
        if (queryRequest == null) {
            queryRequest = new QueryRequest() {

                private final Map<String, Collection<String>> params = new HashMap<>();
                private final Map<String, Collection<String>> headers = new HashMap<>();

                @Override
                public String getHttpMethod() {
                    return "GET";
                }

                @Override
                public Map<String, Collection<String>> getHeaders() {
                    return headers;
                }

                @Override
                public Map<String, Collection<String>> getParams() {
                    return params;
                }

                @Override
                public boolean hasParam(String param) {
                    return params.containsKey(param);
                }

                @Override
                public Collection<String> getParam(String param) {
                    return params.get(param);
                }

                @Override
                public String getFirstParam(String param) {
                    return Optional.ofNullable(params.get(param))
                            .map(col -> col.isEmpty() ? null : col.iterator().next())
                            .orElse(null);
                }

                @Override
                public void addParam(String param, String value) {
                    params.computeIfAbsent(param, k -> new ArrayList<>()).add(value);
                }

                @Override
                public void setParam(String param, String value) {
                    Collection<String> values = new ArrayList<>();
                    values.add(value);
                    params.put(param, values);
                }

                @Override
                public void removeParam(String param) {
                    params.remove(param);
                }

                @Override
                public void clearParams() {
                    params.clear();
                }
            };
        }
        return queryRequest;
    }

    @Override
    public Optional<QueryResponse> getQueryResponse() {
        return Optional.ofNullable(queryResponse);
    }
}
