package com.lucidworks.querying.api;

import java.util.Collection;
import java.util.Map;

/**
 * Fusion query request. Part of the {@link QueryRequestAndResponse} and populated before the query has been
 * sent to Solr.
 */
public interface Request {

    /**
     * @return the HTTP method used to send the request to Fusion.
     */
    String getHttpMethod();

    /**
     * @return the map of headers
     */
    Map<String, Collection<String>> getHeaders();

    /**
     * @return the map of query parameters.
     *
     * Certain query parameters may be specified multiple times, e.g.
     * <pre>
     *     debug=timing&amp;debug=query&amp;debug=results
     * </pre>
     */
    Map<String, Collection<String>> getQueryParams();

    /**
     * Whether the query contains the given parameter.
     *
     * @param queryParam a query parameter
     * @return true if the query contained the given the query parameter
     */
    boolean hasQueryParam(String queryParam);

    /**
     * Retrieve the values associated with the given query parameter.
     *
     * @param queryParam a query parameter
     * @return the values associated with the given query parameter.
     */
    Collection<String> getQueryParam(String queryParam);

    /**
     * Add the given query parameter with its associated value to the query.
     *
     * @param queryParam a query parameter
     * @param value the query parameter value
     */
    void addQueryParam(String queryParam, String value);

    /**
     * Set the given query parameter with its associated value on the query.
     * This will override any previously existing query parameters with the same name.
     *
     * @param queryParam a query parameter
     * @param value the query parameter value
     */
    void setQueryParam(String queryParam, String value);

    /**
     * Remove any query parameters from the query that match the given query parameter.
     *
     * @param queryParam a query parameter to remove from the query
     */
    void removeQueryParam(String queryParam);

    /**
     * Remove any query parameters from the query that match the given query parameter and associated value.
     *
     * @param queryParam a query parameter
     * @param value the query parameter value
     */
    void removeQueryParam(String queryParam, String value);

    /**
     * Clear all query parameters from the query.
     */
    void clearQueryParams();
}
