package com.lucidworks.querying;

import com.lucidworks.querying.api.DslQueryRequest;
import com.lucidworks.querying.api.DslQueryRequestResponse;
import com.lucidworks.querying.api.DslQueryResponse;
import com.lucidworks.search.dsl.request.Facets;
import com.lucidworks.search.dsl.request.Results;
import com.lucidworks.search.dsl.request.query.QueryDefinition;
import com.lucidworks.search.dsl.response.Meta;
import com.lucidworks.search.dsl.response.Rules;
import com.lucidworks.search.dsl.response.Spellcheck;

import java.util.HashMap;
import java.util.Map;

public class MockDslQueryRequestResponse implements DslQueryRequestResponse {

    private DslQueryRequest dslQueryRequest;
    private DslQueryResponse dslQueryResponse;

    @Override
    public DslQueryRequest getDslQueryRequest() {
        if (dslQueryRequest == null) {
            dslQueryRequest = new DslQueryRequest() {

                private QueryDefinition queryDefinition;
                private final Map<String, Object> params = new HashMap<>();
                private Results results;
                private Facets facets;
                private final Map<String, Object> context = new HashMap<>();

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
                    return context;
                }
            };
        }

        return dslQueryRequest;
    }

    @Override
    public DslQueryResponse getDslQueryResponse() {
        if (dslQueryResponse == null) {
            dslQueryResponse = new DslQueryResponse() {

                private Meta meta;
                private com.lucidworks.search.dsl.response.Facets facets;
                private com.lucidworks.search.dsl.response.Results results;
                private Spellcheck spellcheck;
                private Map<String, Object> debugResponse;
                private Rules rules;

                @Override
                public Meta getMeta() {
                    return meta;
                }

                @Override
                public com.lucidworks.search.dsl.response.Facets getFacets() {
                    return facets;
                }

                @Override
                public void setFacets(com.lucidworks.search.dsl.response.Facets facets) {
                    this.facets = facets;
                }

                @Override
                public com.lucidworks.search.dsl.response.Results getResults() {
                    return results;
                }

                @Override
                public void setResults(com.lucidworks.search.dsl.response.Results results) {
                    this.results = results;
                }

                @Override
                public Spellcheck getSpellcheck() {
                    return spellcheck;
                }

                @Override
                public void setSpellcheck(Spellcheck spellcheck) {
                    this.spellcheck = spellcheck;
                }

                @Override
                public Map<String, Object> getDebugResponse() {
                    return debugResponse;
                }

                @Override
                public Rules getRules() {
                    return rules;
                }

                @Override
                public void setRules(Rules rules) {
                    this.rules = rules;
                }
            };
        }

        return dslQueryResponse;
    }
}
