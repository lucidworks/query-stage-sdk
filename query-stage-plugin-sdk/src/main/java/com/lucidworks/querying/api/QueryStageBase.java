package com.lucidworks.querying.api;

import com.lucidworks.querying.api.fusion.Fusion;
import com.lucidworks.querying.config.QueryStageConfig;

/**
 * Convenient base class for query pipeline stage containing default initialization logic.
 *
 * Extend this class to implement custom query pipeline stage:
 *
 * <pre>
 * {@literal @}Stage(type = "myStage", configClass = MyStageConfig.class)
 * public class MyStage extends QueryStageBase&lt;MyStageConfig&gt; {
 *
 *   {@literal @}Override
 *   public QueryRequestAndResponse process(QueryRequestAndResponse query, Context context) {
 *     // get configuration
 *     String myBlobId = config.myBlobdId();
 *
 *     // call Fusion API methods
 *     fusion.blobs().getBlobContent(myBlobId);
 *
 *     // further query processing logic
 *   }
 * }
 * </pre>
 *
 * @param <T> query stage configuration class
 */
public abstract class QueryStageBase<T extends QueryStageConfig> implements QueryStage<T> {

    protected Fusion fusion;
    protected T config;

    @Override
    public void init(T config, Fusion fusion) {
        this.config = config;
        this.fusion = fusion;
    }
}
