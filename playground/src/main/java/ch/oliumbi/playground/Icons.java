package ch.oliumbi.playground;

import ch.oliumbi.playground.components.image.Img;

public class Icons {

  public static Img menu() {
    return new Img("/static/svg/menu.svg", "menu", 32, 32);
  }

  public static Img close() {
    return new Img("/static/svg/close.svg", "menu", 32, 32);
  }
}
