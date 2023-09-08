package ch.oliumbi.compass.sql;

public class Postgresql implements Sql {

  @Override
  public String driver() {
    return "org.postgresql.Driver";
  }

  @Override
  public String jdbc(String host, int port, String database) {
    return "jdbc:postgresql://" + host + ":" + port + "/" + database;
  }
}
