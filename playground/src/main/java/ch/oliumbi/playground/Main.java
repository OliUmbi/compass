package ch.oliumbi.playground;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.fx.Fx;

public class Main {

  public static void main(String[] args) {
    Compass.start(Main.class, args);

    Fx.run(args, Home.class);
  }
}
