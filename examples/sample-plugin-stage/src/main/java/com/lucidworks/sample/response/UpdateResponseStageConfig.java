package com.lucidworks.sample.response;

import com.lucidworks.fusion.schema.SchemaAnnotations.RootSchema;
import com.lucidworks.fusion.schema.SchemaAnnotations.Property;
import com.lucidworks.fusion.schema.SchemaAnnotations.StringSchema;
import com.lucidworks.querying.config.QueryStageConfig;

@RootSchema(
        title = "Update Response",
        description = "Update Response Query Stage"
)
public interface UpdateResponseStageConfig extends QueryStageConfig {

    @Property(
            title = "Update Response field",
            description = "Name of field to add to response",
            required = true
    )
    @StringSchema(minLength = 1)
    String field();

    @Property(
            title = "Value",
            description = "Value to add to response field"
    )
    @StringSchema
    String value();
}
