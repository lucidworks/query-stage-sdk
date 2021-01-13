package com.lucidworks.querying.api;

import com.lucidworks.search.dsl.response.Facets;
import com.lucidworks.search.dsl.response.Meta;
import com.lucidworks.search.dsl.response.Results;
import com.lucidworks.search.dsl.response.Rules;
import com.lucidworks.search.dsl.response.Spellcheck;

import java.util.Map;

public interface DslQueryResponse {

    Meta getMeta();

    Facets getFacets();

    void setFacets(Facets facets);

    Results getResults();

    void setResults(Results results);

    Spellcheck getSpellcheck();

    void setSpellcheck(Spellcheck spellcheck);

    Map<String, Object> getDebugResponse();

    Rules getRules();

    void setRules(Rules rules);
}
