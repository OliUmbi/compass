package ch.oliumbi.compass.sql;

public interface Sql {

  String driver();

  String jdbc(String host, int port, String database);
}
