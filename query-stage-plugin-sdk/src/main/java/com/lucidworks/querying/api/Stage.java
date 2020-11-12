package com.lucidworks.querying.api;

import com.lucidworks.querying.config.QueryStageConfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation that informs Fusion that this class should be interpreted as a stage.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Stage {

    /**
     * Stage type name to uniquely identify custom stage.
     *
     * @return Stage type name
     */
    String type();

    /**
     * Stage configuration class.
     *
     * @return Configuration class
     */
    Class<? extends QueryStageConfig> configClass();
}
