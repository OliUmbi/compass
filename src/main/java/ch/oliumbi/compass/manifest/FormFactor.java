package ch.oliumbi.compass.manifest;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/screenshots
 */
public enum FormFactor {
  NARROW,
  WIDE;

  public String translate() {
    switch (this) {
      case NARROW -> {
        return "narrow";
      }
      case WIDE -> {
        return "wide";
      }
      default -> {
        // todo error handling
        System.out.println("Unexpected value: " + this);
        return "narrow";
      }
    }
  }
}
