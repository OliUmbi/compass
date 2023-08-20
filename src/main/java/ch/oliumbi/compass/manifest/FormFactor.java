package ch.oliumbi.compass.manifest;

import ch.oliumbi.compass.enums.Translatable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/screenshots
 */
public enum FormFactor implements Translatable {
  NARROW,
  WIDE;

  public static final Logger LOGGER = LoggerFactory.getLogger(FormFactor.class);

  @Override
  public String translate() {
    switch (this) {
      case NARROW -> {
        return "narrow";
      }
      case WIDE -> {
        return "wide";
      }
      default -> {
        LOGGER.error("Unexpected value: " + this);
        return "narrow";
      }
    }
  }
}
