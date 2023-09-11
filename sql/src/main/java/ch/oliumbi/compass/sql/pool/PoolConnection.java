package ch.oliumbi.compass.sql.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoolConnection implements AutoCloseable {

  private final Pool pool;
  private final Connection connection;

  public PoolConnection(Pool pool, Connection connection) {
    this.pool = pool;
    this.connection = connection;
  }

  @Override
  public void close() throws Exception {
    pool.surrender(this);
  }

  public PreparedStatement preparedStatement(String sql) throws SQLException {
    return connection.prepareStatement(sql);
  }

  public boolean isClosed() throws SQLException {
    return connection.isClosed();
  }
}
