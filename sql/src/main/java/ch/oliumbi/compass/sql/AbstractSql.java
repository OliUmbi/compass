package ch.oliumbi.compass.sql;

import ch.oliumbi.compass.sql.exceptions.CompassSqlException;
import ch.oliumbi.compass.sql.pool.Pool;
import ch.oliumbi.compass.sql.pool.PoolConnection;
import ch.oliumbi.compass.sql.query.Query;
import ch.oliumbi.compass.sql.query.QueryService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSql implements Sql {

  public static final Logger LOGGER = LoggerFactory.getLogger(AbstractSql.class);

  private final Pool pool;
  private final QueryService queryService = new QueryService();

  public AbstractSql() {
      pool = new Pool(jdbc(), username(), password(), poolSize(), poolInitial());
  }

  @Override
  public boolean enumAsString() {
    return false;
  }

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
    return pool.lease();
  }

  @Override
  public boolean connected() {
    return pool.connected();
  }

  @Override
  public <T> Optional<List<T>> query(String sql, Class<T> output, Object... inputs) {

    try (PoolConnection connection = pool.lease()) {

      Query query = queryService.parse(sql);

      if (query.outputs().size() == 0) {
        LOGGER.error("No into clause defined, maybe you want to use update() instead");
        return Optional.empty();
      }

      // todo inputs

      // todo execute

      // todo outputs

      return Optional.empty();
    } catch (Exception ignored) {
      return Optional.empty();
    }
  }
}
