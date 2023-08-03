package ch.oliumbi.compass;


import ch.oliumbi.compass.route.Route;
import ch.oliumbi.compass.web.Web;
import java.util.List;

public abstract class Compass {

  public void start(String[] arguments) {
    System.out.println("Started compass");

    Web web = new Web(routes());
    web.start();
  }

  protected abstract List<Route> routes();
}
