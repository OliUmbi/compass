package ch.oliumbi.playground;

import ch.oliumbi.compass.Compass;
import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.playground.pages.HomePage;

@Autoload
public class Main {

  public static void main(String[] args) {
    Compass.start(Main.class, args);
  }
}
