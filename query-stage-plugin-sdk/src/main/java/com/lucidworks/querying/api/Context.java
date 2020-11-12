package com.lucidworks.querying.api;

import java.util.Map;

/**
 * Query pipeline context represented as a {@link Map}.
 *
 * Context properties can be retrieved by calling {@link Map#get(Object)}, and set by calling
 * {@link Map#put(Object, Object)}.
 */
public interface Context extends Map<String, Object> {

    /**
     * @return the name of the collection used by current query pipeline.
     */
    String getCollection();
}
