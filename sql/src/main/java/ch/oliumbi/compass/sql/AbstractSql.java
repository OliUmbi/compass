package ch.oliumbi.compass.sql;

import ch.oliumbi.compass.sql.exceptions.CompassSqlException;
import ch.oliumbi.compass.sql.input.InputService;
import ch.oliumbi.compass.sql.output.OutputService;
import ch.oliumbi.compass.sql.pool.Pool;
import ch.oliumbi.compass.sql.pool.PoolConnection;
import ch.oliumbi.compass.sql.query.Query;
import ch.oliumbi.compass.sql.query.QueryService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSql implements Sql {

  public static final Logger LOGGER = LoggerFactory.getLogger(AbstractSql.class);

  private final QueryService queryService = new QueryService();
  private final InputService inputService = new InputService();
  private final OutputService outputService = new OutputService();
  private Pool pool;

  @Override
  public int poolSize() {
    return 5;
  }

  @Override
  public int poolInitial() {
    return 2;
  }

  @Override
  public PoolConnection connection() throws CompassSqlException {
    if (pool == null) {
      pool = new Pool(jdbc(), username(), password(), poolSize(), poolInitial());;
    }

    return pool.lease();
  }

  @Override
  public boolean connected() {
    if (pool == null) {
      pool = new Pool(jdbc(), username(), password(), poolSize(), poolInitial());;
    }

    return pool.connected();
  }

  @Override
  public <T> Optional<List<T>> query(String sql, Class<T> output, Object... inputs) {

    try (PoolConnection connection = connection()) {

      Query query = queryService.parse(sql);

      if (query.outputs().isEmpty()) {
        LOGGER.error("No into clause defined, maybe you want to use update() instead");
        return Optional.empty();
      }

      PreparedStatement preparedStatement = connection.preparedStatement(query.executable());

      preparedStatement = inputService.build(preparedStatement, query.inputs(), List.of(inputs));

      ResultSet resultSet = preparedStatement.executeQuery();

      return Optional.of(outputService.resolve(resultSet, output, query.outputs()));
    } catch (Exception e) {
      LOGGER.error("Exception occurred while executing sql query", e);
      return Optional.empty();
    }
  }

  @Override
  public <T> Optional<T> querySingle(String sql, Class<T> output, Object... inputs) {
    try (PoolConnection connection = connection()) {

      Query query = queryService.parse(sql);

      if (query.outputs().isEmpty()) {
        LOGGER.error("No into clause defined, maybe you want to use update() instead");
        return Optional.empty();
      }

      PreparedStatement preparedStatement = connection.preparedStatement(query.executable());

      preparedStatement = inputService.build(preparedStatement, query.inputs(), List.of(inputs));

      ResultSet resultSet = preparedStatement.executeQuery();

      List<T> result = outputService.resolve(resultSet, output, query.outputs());

      if (result.size() > 1) {
        LOGGER.error("Query returned multiple results, either query is invalid or query() should be used");
        return Optional.empty();
      }

      if (result.isEmpty()) {
        LOGGER.warn("Query returned no results, either query is invalid or query() should be used");
        return Optional.empty();
      }

      return Optional.of(result.getFirst());
    } catch (Exception e) {
      LOGGER.error("Exception occurred while executing sql query", e);
      return Optional.empty();
    }
  }

  @Override
  public Optional<Integer> update(String sql, Object... inputs) {

    try (PoolConnection connection = connection()) {

      Query query = queryService.parse(sql);

      if (!query.outputs().isEmpty()) {
        LOGGER.error("Into clause defined, maybe you want to use update() instead");
        return Optional.empty();
      }

      PreparedStatement preparedStatement = connection.preparedStatement(query.executable());

      preparedStatement = inputService.build(preparedStatement, query.inputs(), List.of(inputs));

      return Optional.of(preparedStatement.executeUpdate());
    } catch (Exception e) {
      LOGGER.error("Exception occurred while executing sql query", e);
      return Optional.empty();
    }
  }

  @Override
  public Optional<Boolean> exists(String sql, Object... inputs) {

    try (PoolConnection connection = connection()) {

      Query query = queryService.parse(sql);

      if (!query.outputs().isEmpty()) {
        LOGGER.error("Into clause defined, maybe you want to use update() instead");
        return Optional.empty();
      }

      PreparedStatement preparedStatement = connection.preparedStatement(query.executable());

      preparedStatement = inputService.build(preparedStatement, query.inputs(), List.of(inputs));

      ResultSet resultSet = preparedStatement.executeQuery();

      return Optional.of(outputService.exists(resultSet));
    } catch (Exception e) {
      LOGGER.error("Exception occurred while executing sql query", e);
      return Optional.empty();
    }
  }
}
