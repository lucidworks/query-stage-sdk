package com.lucidworks.sample.response;

import com.lucidworks.indexing.sdk.test.QueryStageTestBase;
import com.lucidworks.indexing.sdk.test.TestQueryRequest;
import com.lucidworks.indexing.sdk.test.TestQueryResponse;
import com.lucidworks.querying.api.Document;
import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.UnaryOperator;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class UpdateResponseStageTest extends QueryStageTestBase<UpdateResponseStageConfig> {

    @Test
    public void testProcess() throws ReflectiveOperationException {
        UpdateResponseStageConfig stageConfig = newConfig(UpdateResponseStageConfig.class, config -> {
            when(config.field()).thenReturn("field");
            when(config.value()).thenReturn("value");
        });

        QueryRequest queryRequest = new TestQueryRequest();
        QueryResponse queryResponse = new TestQueryResponse();
        Document document = new TestDocument();
        queryResponse.updateDocuments(Collections.singletonList(document));

        QueryRequestResponse queryRequestResponse = newQueryRequestAndResponse(queryRequest, queryResponse);

        UpdateResponseStage stage = createStage(UpdateResponseStage.class, stageConfig);
        final QueryRequestResponse processedQRR = stage.process(queryRequestResponse, null);

        assertTrue(processedQRR.getQueryResponse().isPresent());
        assertTrue(processedQRR.getQueryResponse().get().getDocuments().get(0).containsField("field"));
        assertTrue(processedQRR.getQueryResponse().get().getDocuments().get(0).getField("field").get().getValues().contains("value"));
    }

    static class TestDocument implements Document {

        private final Set<Field<Object>> fields;

        public TestDocument() {
            fields = new HashSet<>();
        }

        @Override
        public int getNumberOfFields() {
            return getFields().size();
        }

        @Override
        public Set<Field<Object>> getFields() {
            return fields;
        }

        @Override
        public boolean containsField(String field) {
            return fields.stream().anyMatch(f -> f.getName().equals(field));
        }

        @Override
        public Optional<Field<Object>> getField(String field) {
            return fields.stream().filter(f -> f.getName().equals(field)).findFirst();
        }

        @Override
        public Field<Object> setField(String field, Object value) {
            Collection values;
            if (value instanceof Collection) {
                values = (Collection) value;
            } else {
                values = Collections.singletonList(value);
            }

            final TestField testField = new TestField(field, values);
            fields.add(testField);

            return testField;
        }

        @Override
        public void removeField(String field) {

        }

        static class TestField implements Field {

            private final String name;
            private final Collection values;

            public TestField(String name, Collection values) {
                this.name = name;
                this.values = values;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public Collection getValues() {
                return values;
            }

            @Override
            public Field setValue(Object value) {
                return null;
            }

            @Override
            public Field setValues(Collection values) {
                return null;
            }

            @Override
            public Field addValue(Object value) {
                return null;
            }

            @Override
            public Field addValues(Collection values) {
                return null;
            }

            @Override
            public Field map(UnaryOperator mapper) {
                return null;
            }
        }
    }
}
