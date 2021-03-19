package com.lucidworks.querying.api;

import java.util.Collection;
import java.util.Map;

/**
 * Fusion query request. Part of the {@link QueryRequestResponse} and populated before the query has been
 * sent to Solr.
 */
public interface QueryRequest {

    /**
     * @return the HTTP method used to send the request to Fusion.
     */
    String getHttpMethod();

    /**
     * @return the request headers
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
    Map<String, Collection<String>> getParams();

    /**
     * Whether the query contains the given parameter.
     *
     * @param param a query parameter
     * @return true if the query contained the given the query parameter
     */
    boolean hasParam(String param);

    /**
     * Retrieve the values associated with the given query parameter.
     *
     * @param param a query parameter
     * @return the values associated with the given query parameter.
     */
    Collection<String> getParam(String param);

    /**
     * Retrieve first value associated with the given query parameter.
     *
     * @param param a query parameter
     * @return first value associated with the given query parameter.
     */
    String getFirstParam(String param);

    /**
     * Add the given query parameter with its associated value to the query.
     *
     * @param param a query parameter
     * @param value the query parameter value
     */
    void addParam(String param, String value);

    /**
     * Set the given query parameter with its associated value on the query.
     * This will override any previously existing query parameters with the same name.
     *
     * @param param a query parameter
     * @param value the query parameter value
     */
    void setParam(String param, String value);

    /**
     * Remove any query parameters from the query that match the given query parameter.
     *
     * @param param a query parameter to remove from the query
     */
    void removeParam(String param);

    /**
     * Clear all query parameters from the query.
     */
    void clearParams();
}
