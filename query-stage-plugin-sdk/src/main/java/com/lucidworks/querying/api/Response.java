package com.lucidworks.querying.api;

import java.util.List;
import java.util.Map;

/**
 * Fusion query response. Part of the {@link QueryRequestAndResponse} and populated after the result set has been
 * retrieved from Solr.
 */
public interface Response {

    /**
     * @return the total amount of time your query spent passing through the query pipeline
     */
    long getTotalTime();

    /**
     * @return the number of documents in the search index that matched your query
     */
    long getNumFound();

    /**
     * @return the scoring of the topmost document in query’s result set.
     */
    double getMaxScore();

    /**
     * @return the offset into a query’s result set.
     */
    long getStart();

    /**
     * @return the IDs of all the documents in the query’s result set.
     */
    List<String> getDocIds();

    /**
     * @return the documents in the query’s result set.
     */
    List<Document> getDocuments();

    /**
     * Update documents in the query’s result set.
     *
     * This could be used to, for example, reorder, redact, or rewrite documents.
     *
     * @param updatedDocuments a list of updated documents
     */
    void updateDocuments(List<Document> updatedDocuments);

    /**
     * @return the facets in the query’s result set.
     *
     * Returned as 'facet type' mapped to 'field name' mapped to 'facet count entries'.
     */
    Map<String, Map<String, Object>> getFacets();

    /**
     * Update facets in the query’s result set.
     *
     * @param facets a map of updated facets.
     */
    void updateFacets(Map<String, Map<String, Object>> facets);

    /**
     * @return highlighted snippets in the query’s result set.
     *
     * Returned as 'Doc ID' mapped to 'Field name' mapped to 'Snippets'.
     */
    Map<String, Map<String, Object>> getHighlighting();

    /**
     * Update highlighted snippets in the query’s result set.
     *
     * @param highlighting a map of updated highlighted snippets.
     */
    void updateHighlighting(Map<String, Map<String, Object>> highlighting);

    /**
     * @return grouped results in the query’s result set.
     *
     * Returned as 'group field name' or 'group query' mapped to grouping data.
     */
    Map<String, Map<String, Object>> getGroupedResults();
}
