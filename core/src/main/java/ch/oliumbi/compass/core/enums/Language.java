package ch.oliumbi.compass.core.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Language implements Translatable<String> {
  ENGLISH,
  GERMAN;

  public static final Logger LOGGER = LoggerFactory.getLogger(Method.class);

  @Override
  public String translate() {
    switch (this) {
      case ENGLISH -> {
        return "en";
      }
      case GERMAN -> {
        return "de";
      }
      default -> {
        LOGGER.error("Unexpected value: " + this);
        return "en";
      }
    }
  }
}
