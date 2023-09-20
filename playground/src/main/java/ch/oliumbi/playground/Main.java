package ch.oliumbi.playground;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.fx.Fx;
import javafx.application.Platform;

public class Main {

  public static void main(String[] args) {
    Fx.run(args, Main.class, Home.class);
  }
}
