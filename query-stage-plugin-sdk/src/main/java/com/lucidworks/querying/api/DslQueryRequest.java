package com.lucidworks.querying.api;


import com.lucidworks.search.dsl.request.Facets;
import com.lucidworks.search.dsl.request.Results;
import com.lucidworks.search.dsl.request.query.QueryDefinition;

import java.util.Map;

public interface DslQueryRequest {

    /**
     * @return search query parameters
     */
    QueryDefinition getQueryDefinition();

    void setQueryDefinition(QueryDefinition queryDefinition);

    /**
     * @return a map that holds request parameters that will be added to the underlying query to search engine
     */
    Map<String, Object> getParams();

    /**
     * @return search result parameters
     */
    Results getResults();

    /**
     * @return facet parameters
     */
    Facets getFacets();

    void setFacets(Facets facets);

    /**
     * @return a map that holds additional parameters that are used by some stages or DSL hints
     */
    Map<String, Object> getContext();
}
