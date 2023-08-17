package ch.oliumbi.compass.manifest;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/display
 */
public enum Display {
  FULLSCREEN, // fullscreen
  STANDALONE, // no navigation
  MINIMAL_UI, // not quite a browser but close
  BROWSER; // standard browser

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
      case BROWSER -> {
        return "browser";
      }
      default -> {
        // todo error handling
        System.out.println("Unexpected value: " + this);
        return "browser";
      }
    }
  }
}
