package com.lucidworks.sample.request;

import com.lucidworks.fusion.schema.SchemaAnnotations.RootSchema;
import com.lucidworks.fusion.schema.SchemaAnnotations.Property;
import com.lucidworks.fusion.schema.SchemaAnnotations.StringSchema;
import com.lucidworks.querying.config.QueryStageConfig;

@RootSchema(
        title = "Update Request",
        description = "Update Request Query Stage"
)
public interface UpdateRequestStageConfig extends QueryStageConfig {

    @Property(
            title = "Query parameter",
            description = "Name of query parameter to add to request",
            required = true
    )
    @StringSchema(minLength = 1)
    String queryParam();

    @Property(
            title = "Value",
            description = "Text to put into the query parameter."
    )
    @StringSchema
    String value();
}
