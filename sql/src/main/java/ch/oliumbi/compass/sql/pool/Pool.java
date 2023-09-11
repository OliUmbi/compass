package ch.oliumbi.compass.sql.pool;

import static ch.oliumbi.compass.sql.AbstractSql.LOGGER;

import ch.oliumbi.compass.sql.exceptions.CompassSqlException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Pool {

  private final String jdbc;
  private final String username;
  private final String password;
  private BlockingQueue<PoolConnection> pool;

  public Pool(String jdbc, String username, String password, int size, int initial) {
    this.jdbc = jdbc;
    this.username = username;
    this.password = password;

    size = size > 0 ? size : 5;
    initial = initial > 0 ? initial : 2;

    pool = new LinkedBlockingDeque<>(size);

    for (int i = 0; i < initial; i++) {
      try {
        open();
      } catch (CompassSqlException e) {
        LOGGER.error("Failed to initialize Sql connection, jdbc " + jdbc);
        throw new RuntimeException();
      }
    }
  }

  public PoolConnection lease() throws CompassSqlException {
    try {
      if (pool.peek() == null && pool.remainingCapacity() != 0) {
        open();
      }

      PoolConnection poolConnection = pool.take();

      if (poolConnection.isClosed()) {
        poolConnection = connect();
      }

      return poolConnection;
    } catch (SQLException e) {
      LOGGER.error("Database access error occurred, while checking if connection is closed", e);
      throw new CompassSqlException();
    } catch (InterruptedException e) {
      LOGGER.error("Pool got interrupted", e);
      throw new CompassSqlException();
    }
  }

  public void surrender(PoolConnection poolConnection) {
    pool.offer(poolConnection);
  }

  public boolean connected() {
    return pool.stream().anyMatch(poolConnection -> {
      try {
        return !poolConnection.isClosed();
      } catch (SQLException e) {
        LOGGER.error("Database access error occurred, while checking if connection is closed", e);
        return false;
      }
    });
  }

  private synchronized void open() throws CompassSqlException {
    if (pool.remainingCapacity() == 0) {
      return;
    }

    pool.offer(connect());
  }

  private PoolConnection connect() throws CompassSqlException {
    try {
      LOGGER.info("Connecting to " + jdbc);
      return new PoolConnection(this, DriverManager.getConnection(jdbc, username, password));
    } catch (SQLTimeoutException e) {
      LOGGER.error("Timeout exceeded, while creating connection", e);
      throw new CompassSqlException();
    } catch (SQLException e) {
      LOGGER.error("Database access error occurred or the url is null, while creating connection", e);
      throw new CompassSqlException();
    }
  }
}
