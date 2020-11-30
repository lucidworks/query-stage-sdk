package com.lucidworks.indexing.sdk.test;

import com.lucidworks.querying.api.Document;
import com.lucidworks.querying.api.QueryResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TestQueryResponse implements QueryResponse {

    private List<Document> documents = new ArrayList<>();

    private Map<String, Map<String, Object>> facets = new HashMap<>();

    private Map<String, Map<String, Object>> highlighting = new HashMap<>();

    private Map<String, Map<String, Object>> groupedResults = new HashMap<>();

    @Override
    public Optional<Integer> getStatusCode() {
        return Optional.empty();
    }

    @Override
    public Map<String, Collection<String>> getHeaders() {
        return Collections.emptyMap();
    }

    @Override
    public long getTotalTime() {
        return 0;
    }

    @Override
    public long getNumFound() {
        return 0;
    }

    @Override
    public double getMaxScore() {
        return 0;
    }

    @Override
    public long getStart() {
        return 0;
    }

    @Override
    public List<String> getDocIds() {
        return null;
    }

    @Override
    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public void updateDocuments(List<Document> updatedDocuments) {
        documents = updatedDocuments;
    }

    @Override
    public Map<String, Map<String, Object>> getFacets() {
        return facets;
    }

    @Override
    public void updateFacets(Map<String, Map<String, Object>> updatedFacets) {
        facets = updatedFacets;
    }

    @Override
    public Map<String, Map<String, Object>> getHighlighting() {
        return highlighting;
    }

    @Override
    public void updateHighlighting(Map<String, Map<String, Object>> updatedHighlighting) {
        highlighting = updatedHighlighting;
    }

    @Override
    public Map<String, Map<String, Object>> getGroupedResults() {
        return groupedResults;
    }
}
