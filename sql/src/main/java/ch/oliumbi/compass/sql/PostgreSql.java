package ch.oliumbi.compass.sql;

public abstract class PostgreSql extends AbstractSql {

  @Override
  public String jdbc() {
    return "jdbc:postgresql://" + host() + ":" + port() + "/" + database();
  }
}
