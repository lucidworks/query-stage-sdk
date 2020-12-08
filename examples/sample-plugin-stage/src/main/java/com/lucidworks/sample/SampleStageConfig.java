package com.lucidworks.sample;

import com.lucidworks.fusion.schema.SchemaAnnotations.RootSchema;
import com.lucidworks.fusion.schema.SchemaAnnotations.Property;
import com.lucidworks.fusion.schema.SchemaAnnotations.StringSchema;
import com.lucidworks.querying.config.QueryStageConfig;

@RootSchema(
        title = "Sample",
        description = "Sample Query Stage"
)
public interface SampleStageConfig extends QueryStageConfig {

    @Property(
            title = "Query parameter",
            description = "Name of query parameter to add to request",
            required = true
    )
    @StringSchema(minLength = 1)
    String queryParam();

    @Property(
            title = "Value",
            description = "Sample text to put into the query parameter."
    )
    @StringSchema
    String value();
}
