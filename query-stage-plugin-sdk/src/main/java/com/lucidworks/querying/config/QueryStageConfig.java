package com.lucidworks.querying.config;

import com.lucidworks.fusion.schema.Model;

/**
 * Query pipeline stage configuration definition.
 *
 * Extend this interface to define a configuration for a custom query stage.
 *
 * An example of a query stage configuration:
 * <pre>
 * {@literal @}RootSchema(
 *     title = "Sample",
 *     description = "Sample Query Stage"
 * )
 * public interface MyStageConfig extends QueryStageConfig {
 *
 *   {@literal @}Property(
 *       title = "My String Property",
 *       description = "Example string property..."
 *   )
 *   {@literal @}StringSchema(defaultValue = "example string")
 *   String myStringProperty();
 *
 *   {@literal @}Property(
 *       title = "My Integer Property",
 *       description = "Example integer property...",
 *       required = true)
 *   {@literal @}NumberSchema(minimum = 1, maximum = 100)
 *   Integer myIntegerProperty();
 * }
 * </pre>
 */
public interface QueryStageConfig extends Model {
}
