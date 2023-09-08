package ch.oliumbi.compass.sql;

public class MySql implements Sql {

  @Override
  public String driver() {
    return "com.mysql.jdbc.Driver";
  }

  @Override
  public String jdbc(String host, int port, String database) {
    return "jdbc:mysql://" + host + ":" + port + "/" + database;
  }
}
