package com.lucidworks.querying.api;

import com.lucidworks.querying.api.fusion.Fusion;
import com.lucidworks.querying.config.QueryStageConfig;

import java.util.Optional;
import java.util.function.Consumer;

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
     * Process a single queryRequestResponse. This method is called for each queryRequestResponse passing through a query pipeline.
     *
     * Implement this method to perform processing of a single {@link QueryRequestResponse} instance that results in either 1 or 0
     * queryRequestResponses being emitted. Return null to drop query from the pipeline.
     *
     * Note that this method implementation must be thread-safe as it can be invoked concurrently by multiple threads.
     *
     * @param queryRequestResponse queryRequestResponse going through query pipeline
     * @param context query pipeline context
     * @return processed query or null to drop query from the pipeline
     */
    default QueryRequestResponse process(QueryRequestResponse queryRequestResponse, Context context) {
        return queryRequestResponse;
    }

    /**
     * Process single queryRequestResponse. This method is called for each queryRequestResponse passing through index pipeline.
     *
     * Implement this method to perform processing of single {@link QueryRequestResponse} instance that results in arbitrary
     * number of queryRequestResponses being emitted. Call <code>output.accept(queryRequestResponse)</code> for each queryRequestResponse you want to
     * emit as a result of processing. Note that after sending a queryRequestResponse instance to the output, its state
     * may be changed by subsequent stages, therefore it is strongly advised to discard the queryRequestResponse instance
     * immediately after emitting it. Passing <code>null</code> to <code>output</code> consumer will cause
     * {@link IllegalArgumentException}.
     *
     * Overriding the default implementation of this method will result in {@link #process(QueryRequestResponse, Context)} to
     * not be called. Default implementation is to call {@link #process(QueryRequestResponse, Context)} method.
     *
     * Note that this method implementation must be thread-safe as it can be invoked concurrently by multiple threads.
     *
     * @param queryRequestResponse queryRequestResponse going through query pipeline
     * @param context query pipeline context
     * @param output consumer for queryRequestResponses emitted as the result of processing
     */
    default void process(QueryRequestResponse queryRequestResponse, Context context, Consumer<QueryRequestResponse> output) {
        Optional.ofNullable(process(queryRequestResponse, context)).ifPresent(output);
    }
}
