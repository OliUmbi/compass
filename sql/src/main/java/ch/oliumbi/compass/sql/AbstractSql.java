package ch.oliumbi.compass.sql;

import ch.oliumbi.compass.sql.exceptions.CompassSqlException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSql implements Sql {

  public static final Logger LOGGER = LoggerFactory.getLogger(AbstractSql.class);

  private Connection connection;

  protected Connection connection() throws CompassSqlException {

    if (connected()) {
      return connection;
    }

    try {
      connection = DriverManager.getConnection(jdbc(), username(), password());
      LOGGER.info("Connected to " + jdbc());

      return connection;
    } catch (SQLTimeoutException e) {
      LOGGER.error("Timeout exceeded, while creating connection", e);
      throw new CompassSqlException();
    } catch (SQLException e) {
      LOGGER.error("Database access error occurred or the url is null, while creating connection", e);
      throw new CompassSqlException();
    }
  }

  public boolean connected() {
    if (connection == null) {
      return false;
    }

    try {
      return !connection.isClosed();
    } catch (SQLException e) {
      LOGGER.error("Database access error occurred, while checking if connection is closed", e);
    }

    return false;
  }
}
