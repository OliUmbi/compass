package ch.oliumbi.compass.server.page.manifest;

import ch.oliumbi.compass.core.enums.Translatable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/display
 */
public enum Display implements Translatable {
  FULLSCREEN, // fullscreen
  STANDALONE, // no navigation
  MINIMAL_UI; // not quite a browser but close

  public static final Logger LOGGER = LoggerFactory.getLogger(Display.class);

  @Override
  public String translate() {
    switch (this) {
      case FULLSCREEN -> {
        return "fullscreen";
      }
      case STANDALONE -> {
        return "standalone";
      }
      case MINIMAL_UI -> {
        return "minimal-ui";
      }
      default -> {
        // todo error handling
        LOGGER.error("Unexpected value: " + this);
        return "browser";
      }
    }
  }
}
