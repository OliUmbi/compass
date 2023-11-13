package ch.oliumbi.compass.server.html.enums;

import ch.oliumbi.compass.server.html.Renderable;

public enum Language implements Renderable {
  ENGLISH,
  GERMAN;

  // todo move to proper place

  @Override
  public String render() {
    switch (this) {
      case ENGLISH -> {
        return "en";
      }
      case GERMAN -> {
        return "de";
      }
      default -> {
        return "en";
      }
    }
  }
}
