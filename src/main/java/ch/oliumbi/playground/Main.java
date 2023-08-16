package ch.oliumbi.playground;

import ch.oliumbi.compass.Compass;
import ch.oliumbi.compass.annotations.North;
import ch.oliumbi.compass.route.Route;
import java.util.List;

@North
public class Main {

  public static void main(String[] args) {
    Compass.start(Main.class, args);
  }
}
