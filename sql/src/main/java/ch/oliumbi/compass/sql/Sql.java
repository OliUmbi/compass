package ch.oliumbi.compass.sql;

import ch.oliumbi.compass.sql.exceptions.CompassSqlException;
import ch.oliumbi.compass.sql.pool.Pool;
import ch.oliumbi.compass.sql.pool.PoolConnection;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface Sql {


  String jdbc();

  String host();

  String port();

  String database();

  String username();

  String password();

  int poolSize();

  int poolInitial();

  boolean enumAsString();

  PoolConnection connection() throws CompassSqlException;

  boolean connected();

  <T> Optional<List<T>> query(String sql, Class<T> output, Object... inputs);

  <T> Optional<T> querySingle(String sql, Class<T> output, Object... inputs);

  Optional<Integer> update(String sql, Object... inputs);

  Optional<Boolean> exists(String sql, Object... inputs);
}
