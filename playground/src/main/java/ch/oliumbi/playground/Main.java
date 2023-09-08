package ch.oliumbi.playground;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.server.Server;

public class Main {

  public static void main(String[] args) {
    Compass.start(Main.class, args);
    Server.start();
  }
}
