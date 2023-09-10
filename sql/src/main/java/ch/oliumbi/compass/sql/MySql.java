package ch.oliumbi.compass.sql;

public abstract class MySql extends AbstractSql {

  @Override
  public String driver() {
    return "com.mysql.jdbc.Driver";
  }

  @Override
  public String jdbc() {
    return "jdbc:mysql://" + host() + ":" + port() + "/" + database();
  }
}
