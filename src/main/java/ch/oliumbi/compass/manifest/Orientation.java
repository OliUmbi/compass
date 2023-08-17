package ch.oliumbi.compass.manifest;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/orientation
 */
public enum Orientation {
  ANY,
  NATURAL,
  LANDSCAPE,
  LANDSCAPE_PRIMARY,
  LANDSCAPE_SECONDARY,
  PORTRAIT,
  PORTRAIT_PRIMARY,
  PORTRAIT_SECONDARY;

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
        // todo error handling
        System.out.println("Unexpected value: " + this);
        return "any";
      }
    }
  }
}
