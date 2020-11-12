package com.lucidworks.querying.api;

import com.lucidworks.querying.api.fusion.Fusion;
import com.lucidworks.querying.config.QueryStageConfig;

/**
 * Fusion query pipeline stage. Custom query stages must implement this interface to be discovered and called
 * by Fusion.
 *
 * Example of custom query stage class:
 * <pre>
 * {@literal @}Stage(type = "myStage", configClass = MyStageConfig.class)
 * public class MyStage implements QueryStage&lt;MyStageConfig&gt; {
 *
 *   {@literal @}Override
 *   public void init(MyStageConfig config, Fusion fusion) {
 *     // stage initialization logic
 *   }
 *
 *   {@literal @}Override
 *   public Document process(Document document, Context context) {
 *     // document processing logic
 *   }
 * </pre>
 *
 * Implementations of this class must be stateless. Fusion can create and use multiple query stage instances
 * at the same time.
 *
 * @param <T> query stage configuration class
 */
public interface QueryStage<T extends QueryStageConfig> {

    /**
     * Stage initialization callback. This method will be called by Fusion when query stage instance is created
     * and before 'process' method is called.
     *
     * Stage configuration will be passed by Fusion as {@link QueryStageConfig} instance. Additionally {@link Fusion}
     * interface instance will be passed to allow calling Fusion API from the query stage.
     *
     * @param config query pipeline stage configuration
     * @param fusion Fusion API instance
     */
    void init(T config, Fusion fusion);

    /**
     * Process a single query. This method is called for each query passing through a query pipeline.
     *
     * Implement this method to perform processing of a single {@link QueryRequestAndResponse} instance that results in either 1 or 0
     * queries being emitted. Return null to drop query from the pipeline.
     *
     * Note that this method implementation must be thread-safe as it can be invoked concurrently by multiple threads.
     *
     * @param query query going through query pipeline
     * @param context query pipeline context
     * @return processed query or null to drop query from the pipeline
     */
    default QueryRequestAndResponse process(QueryRequestAndResponse query, Context context) {
        return query;
    }
}
