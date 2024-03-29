package com.lucidworks.querying.sdk.test;

import com.lucidworks.querying.api.DslQueryRequest;
import com.lucidworks.querying.api.DslQueryRequestResponse;
import com.lucidworks.querying.api.DslQueryResponse;
import com.lucidworks.querying.api.QueryRequest;
import com.lucidworks.querying.api.QueryRequestResponse;
import com.lucidworks.querying.api.QueryResponse;
import com.lucidworks.querying.api.QueryStage;
import com.lucidworks.querying.api.fusion.Fusion;
import com.lucidworks.querying.config.QueryStageConfig;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Consumer;

/**
 * Base class for query stage unit tests.
 * @param <C> query stage config class
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class QueryStageTestBase<C extends QueryStageConfig> {

  @Mock
  protected Fusion fusion;

  /**
   * Create query stage instance using provided config.
   *
   * @param stageClass query stage class
   * @param config query stage config instance
   * @param <S> query stage class
   * @return initialized query stage instance
   * @throws ReflectiveOperationException when unable to instantiate stage class using default no param constructor
   */
  public <S extends QueryStage<C>> S createStage(Class<S> stageClass, C config) throws ReflectiveOperationException {
    S stage = stageClass.getDeclaredConstructor().newInstance();
    stage.init(config, fusion);

    return stage;
  }

  /**
   * Create new DSL query request response.
   *
   * @param dslQueryRequest DslQueryRequest instance
   * @param dslQueryResponse DslQueryResponse instance
   * @return DSL query request response instance
   */
  public DslQueryRequestResponse newDslQueryRequestResponse(DslQueryRequest dslQueryRequest, DslQueryResponse dslQueryResponse) {
    return new TestDslQueryRequestResponse(dslQueryRequest, dslQueryResponse);
  }

  /**
   * Create new query request response.
   *
   * @param queryRequest QueryRequest instance
   * @param queryResponse QueryResponse instance
   * @return query request response instance
   */
  public QueryRequestResponse newQueryRequestResponse(QueryRequest queryRequest, QueryResponse queryResponse) {
    return new TestQueryRequestResponse(queryRequest, queryResponse);
  }

  /**
   * Create new query stage config instance.
   *
   * @param configClass query stage config class
   * @return query stage config instance
   */
  public C newConfig(Class<C> configClass) {
    return newConfig(configClass, config -> {});
  }

  /**
   * Create new query stage config instance with mock setup callback.
   * The callback can be used to setup return values for the config mock, e.g.
   *
   * <pre>
   *   SimpleStageConfig stageConfig = newConfig(SimpleStageConfig.class, config -&gt; {
   *     when(config.field()).thenReturn("field_name");
   *     when(config.text()).thenReturn("text_value");
   *   });
   * </pre>
   *
   * @param configClass query stage config class
   * @param mockConfiguration mock setup callback
   * @return query stage config instance
   */
  public C newConfig(Class<C> configClass, Consumer<C> mockConfiguration) {
    C config = Mockito.mock(configClass, Mockito.RETURNS_DEEP_STUBS);
    mockConfiguration.accept(config);
    return config;
  }
}
