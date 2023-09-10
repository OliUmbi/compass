package ch.oliumbi.compass.sql;

public interface Sql {

  String driver();

  String jdbc();

  String host();

  String port();

  String database();

  String username();

  String password();
}
