package ch.oliumbi.compass.sql;

public abstract class MySql extends AbstractSql {

  @Override
  public String jdbc() {
    return "jdbc:mysql://" + host() + ":" + port() + "/" + database();
  }
}
