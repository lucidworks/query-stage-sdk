package com.lucidworks.response;

import com.lucidworks.fusion.schema.SchemaAnnotations.Property;
import com.lucidworks.fusion.schema.SchemaAnnotations.StringSchema;
import com.lucidworks.querying.config.QueryStageConfig;

public interface UpdateResponseStageConfig extends QueryStageConfig {

    @Property(
            title = "Response field",
            description = "Name of field to add to response",
            required = true
    )
    @StringSchema(minLength = 1)
    String field();

    @Property(
            title = "Value",
            description = "Value to add to field in response."
    )
    @StringSchema
    String value();
}
