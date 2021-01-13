package com.lucidworks.querying.sdk.test;

import com.lucidworks.querying.api.DslQueryResponse;
import com.lucidworks.search.dsl.response.Facets;
import com.lucidworks.search.dsl.response.Meta;
import com.lucidworks.search.dsl.response.Results;
import com.lucidworks.search.dsl.response.Rules;
import com.lucidworks.search.dsl.response.Spellcheck;

import java.util.Map;

public class TestDslQueryResponse implements DslQueryResponse {

    private Meta meta;
    private Facets facets;
    private Results results;
    private Spellcheck spellcheck;
    private Map<String, Object> debugResponse;
    private Rules rules;

    @Override
    public Meta getMeta() {
        return meta;
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
    public Results getResults() {
        return results;
    }

    @Override
    public void setResults(Results results) {
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
    public Rules getRules() {
        return rules;
    }

    @Override
    public void setRules(Rules rules) {
        this.rules = rules;
    }

    @Override
    public Map<String, Object> getDebugResponse() {
        return debugResponse;
    }
}
