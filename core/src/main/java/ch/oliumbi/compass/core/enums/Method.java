package ch.oliumbi.compass.core.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Method implements Translatable<String> {
  READ,
  CREATE,
  UPDATE,
  DELETE;

  public static final Logger LOGGER = LoggerFactory.getLogger(Method.class);

  public static Method create(String string) {
    switch (string) {
      case "GET", "OPTIONS" -> {
        return Method.READ;
      }
      case "POST" -> {
        return Method.CREATE;
      }
      case "PUT" -> {
        return Method.UPDATE;
      }
      case "DELETE" -> {
        return Method.DELETE;
      }
      default -> {
        LOGGER.error("Unexpected value: " + string);
        return Method.READ;
      }
    }
  }

  @Override
  public String translate() {
    switch (this) {
      case Method.READ -> {
        return "GET";
      }
      case Method.CREATE -> {
        return "POST";
      }
      case Method.UPDATE -> {
        return "PUT";
      }
      case Method.DELETE -> {
        return "DELETE";
      }
      default -> {
        LOGGER.error("Unexpected value: " + this);
        return "GET";
      }
    }
  }
}
