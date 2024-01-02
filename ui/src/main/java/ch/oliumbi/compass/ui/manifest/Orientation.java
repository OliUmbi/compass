package ch.oliumbi.compass.ui.manifest;

import ch.oliumbi.compass.core.enums.Translatable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/orientation
 */
public enum Orientation implements Translatable<String> {
  ANY,
  NATURAL,
  LANDSCAPE,
  LANDSCAPE_PRIMARY,
  LANDSCAPE_SECONDARY,
  PORTRAIT,
  PORTRAIT_PRIMARY,
  PORTRAIT_SECONDARY;

  public static final Logger LOGGER = LoggerFactory.getLogger(Orientation.class);

  @Override
  public String translate() {
    switch (this) {
      case ANY -> {
        return "any";
      }
      case NATURAL -> {
        return "natural";
      }
      case LANDSCAPE -> {
        return "landscape";
      }
      case LANDSCAPE_PRIMARY -> {
        return "landscape-primary";
      }
      case LANDSCAPE_SECONDARY -> {
        return "landscape-secondary";
      }
      case PORTRAIT -> {
        return "portrait";
      }
      case PORTRAIT_PRIMARY -> {
        return "portrait-primary";
      }
      case PORTRAIT_SECONDARY -> {
        return "portrait-secondary";
      }
      default -> {
        LOGGER.error("Unexpected value: " + this);
        return "any";
      }
    }
  }
}
