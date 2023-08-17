package ch.oliumbi.compass.enums;

public enum MimeType {
  HTML,
  CSS,
  JAVASCRIPT,
  JSON,
  XML,
  MULTI_PART,
  PDF,
  PNG,
  JPEG,
  SVG,
  ICON,
  WOFF2,
  TTF,
  OTF;

  public String translate() {
    switch (this) {
      case HTML -> {
        return "text/html";
      }
      case CSS -> {
        return "text/css";
      }
      case JAVASCRIPT -> {
        return "text/javascript";
      }
      case JSON -> {
        return "application/json";
      }
      case MULTI_PART -> {
        return "multipart/form-data";
      }
      case XML -> {
        return "application/xml";
      }
      case PDF -> {
        return "application/pdf";
      }
      case PNG -> {
        return "image/png";
      }
      case JPEG -> {
        return "image/jpeg";
      }
      case SVG -> {
        return "image/svg+xml";
      }
      case ICON -> {
        return "image/vnd.microsoft.icon";
      }
      case WOFF2 -> {
        return "font/woff2";
      }
      case TTF -> {
        return "font/ttf";
      }
      case OTF -> {
        return "font/otf";
      }
      default -> {
        // todo error handling
        System.out.println("Unexpected value: " + this);
        return "text/plain";
      }
    }
  }
}
