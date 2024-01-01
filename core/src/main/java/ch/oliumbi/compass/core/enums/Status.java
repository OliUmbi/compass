package ch.oliumbi.compass.core.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Status implements Translatable<Integer> {
  OK,
  UNAUTHORIZED,
  FORBIDDEN,
  ERROR_USER,
  ERROR_SERVER;

  public static final Logger LOGGER = LoggerFactory.getLogger(MimeType.class);

  @Override
  public Integer translate() {
    switch (this) {
      case OK -> {
        return 200;
      }
      case UNAUTHORIZED -> {
        return 401;
      }
      case FORBIDDEN -> {
        return 403;
      }
      case ERROR_USER -> {
        return 400;
      }
      case ERROR_SERVER -> {
        return 500;
      }
      default -> {
        LOGGER.error("Unexpected value: " + this);
        return 0;
      }
    }
  }
}
