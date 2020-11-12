package com.lucidworks.querying.api;

import java.util.Collection;
import java.util.Set;
import java.util.function.UnaryOperator;

/**
 * A document in the query {@link Response}.
 *
 * Documents in the query's result set may be accessed by calling
 * {@link QueryRequestAndResponse#getResponse()}.{@link Response#getDocuments()}
 */
public interface Document {

    /**
     * @return the number of fields in the document.
     */
    int getNumberOfFields();

    /**
     * @return a set of fields in the document.
     */
    Set<Field<Object>> getFields();

    /**
     * Whether the document contains the given field.
     *
     * @param field the name of the field
     * @return true if the document contains the given field
     */
    boolean containsField(String field);

    /**
     * Retrieve from the document the given field.
     *
     * @param field the name of the field to retrieve
     * @return the retrieved field or null if the field is not in the document
     */
    Field<Object> getField(String field);

    /**
     * Set the given field with the given value on the document.
     *
     * This will override any previously existing field on the the document that had the same name.
     *
     * @param field the name of the field
     * @param value the value of the field
     */
    void setField(String field, Object value);

    /**
     * Remove the given field from the document.
     *
     * @param field the name of the field.
     */
    void removeField(String field);

    /**
     * Representation of single field in document. Fields can be multivalued
     *
     * @param <T> Type of field values
     */
    interface Field<T> {

        /**
         * @return the field name
         */
        String getName();

        /**
         * @return the field values
         */
        Collection<T> getValues();

        /**
         * Set new value for this field.
         *
         * This will override any previously existing values.
         *
         * @param value Value to set
         * @return this field, with modified list of values
         */
        Field<T> setValue(T value);

        /**
         * Set new values for this field.
         *
         * This will override any previously existing values.
         *
         * @param values Collection of values to set
         * @return this field, with a modified list of values
         */
        Field<T> setValues(Collection<T> values);

        /**
         * Add a value to the field.
         *
         * This will not override any previously existing values.
         *
         * @param value Value to add
         * @return this field, with a modified list of values
         */
        Field<T> addValue(T value);

        /**
         * Add more values to the field.
         *
         * This will not override any previously existing values.
         *
         * @param values Collection of values to add
         * @return this field, with a modified list of values
         */
        Field<T> addValues(Collection<T> values);

        /**
         * Get the first value from the field.
         *
         * This is useful for doing manipulations with single-valued fields.
         *
         * @return the first value from the field.
         */
        T getFirst();

        /**
         * Apply mapping function to each field value.
         *
         * @param mapper Mapping function
         * @return This field
         */
        Field<T> map(UnaryOperator<T> mapper);
    }
}
