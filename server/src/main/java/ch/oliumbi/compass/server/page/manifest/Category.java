package ch.oliumbi.compass.server.page.manifest;

import ch.oliumbi.compass.core.enums.Translatable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/categories
 */
public enum Category implements Translatable {
  BOOKS,
  BUSINESS,
  EDUCATION,
  ENTERTAINMENT,
  FINANCE,
  FITNESS,
  FOOD,
  GAMES,
  GOVERNMENT,
  HEALTH,
  KIDS,
  LIFESTYLE,
  MAGAZINES,
  MEDICAL,
  MUSIC,
  NAVIGATION,
  NEWS,
  PERSONALIZATION,
  PHOTO,
  POLITICS,
  PRODUCTIVITY,
  SECURITY,
  SHOPPING,
  SOCIAL,
  SPORTS,
  TRAVEL,
  UTILITIES,
  WEATHER;

  public static final Logger LOGGER = LoggerFactory.getLogger(Category.class);

  @Override
  public String translate() {
    switch (this) {
      case BOOKS -> {
        return "books";
      }
      case BUSINESS -> {
        return "business";
      }
      case EDUCATION -> {
        return "education";
      }
      case ENTERTAINMENT -> {
        return "entertainment";
      }
      case FINANCE -> {
        return "finance";
      }
      case FITNESS -> {
        return "fitness";
      }
      case FOOD -> {
        return "food";
      }
      case GAMES -> {
        return "games";
      }
      case GOVERNMENT -> {
        return "government";
      }
      case HEALTH -> {
        return "health";
      }
      case KIDS -> {
        return "kids";
      }
      case LIFESTYLE -> {
        return "lifestyle";
      }
      case MAGAZINES -> {
        return "magazines";
      }
      case MEDICAL -> {
        return "medical";
      }
      case MUSIC -> {
        return "music";
      }
      case NAVIGATION -> {
        return "navigation";
      }
      case NEWS -> {
        return "news";
      }
      case PERSONALIZATION -> {
        return "personalization";
      }
      case PHOTO -> {
        return "photo";
      }
      case POLITICS -> {
        return "politics";
      }
      case PRODUCTIVITY -> {
        return "productivity";
      }
      case SECURITY -> {
        return "security";
      }
      case SHOPPING -> {
        return "shopping";
      }
      case SOCIAL -> {
        return "social";
      }
      case SPORTS -> {
        return "sports";
      }
      case TRAVEL -> {
        return "travel";
      }
      case UTILITIES -> {
        return "utilities";
      }
      case WEATHER -> {
        return "weather";
      }
      default -> {
        LOGGER.error("Unexpected value: " + this);
        return "";
      }
    }
  }
}
