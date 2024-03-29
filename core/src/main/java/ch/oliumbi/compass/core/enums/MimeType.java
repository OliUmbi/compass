package ch.oliumbi.compass.core.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum MimeType implements Translatable<String> {
  PLAIN,
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

  public static final Logger LOGGER = LoggerFactory.getLogger(MimeType.class);

  @Override
  public String translate() {
    switch (this) {
      case PLAIN -> {
        return "text/plain";
      }
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
        LOGGER.error("Unexpected value: " + this);
        return "text/plain";
      }
    }
  }

  public String extension() {
    switch (this) {
      case HTML -> {
        return ".html";
      }
      case CSS -> {
        return ".css";
      }
      case JAVASCRIPT -> {
        return ".js";
      }
      case JSON -> {
        return ".json";
      }
      case XML -> {
        return ".xml";
      }
      case PDF -> {
        return ".pdf";
      }
      case PNG -> {
        return ".png";
      }
      case JPEG -> {
        return ".jpg";
      }
      case SVG -> {
        return ".svg";
      }
      case ICON -> {
        return ".ico";
      }
      case WOFF2 -> {
        return ".woff2";
      }
      case TTF -> {
        return ".ttf";
      }
      case OTF -> {
        return ".otf";
      }
      default -> {
        return "";
      }
    }
  }
}
