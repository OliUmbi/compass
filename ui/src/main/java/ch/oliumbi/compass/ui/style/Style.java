package ch.oliumbi.compass.ui.style;

import java.util.ArrayList;
import java.util.List;

public class Style {

  private List<Property> properties = new ArrayList<>();

  public Style position(String value) {
    properties.add(new Property("position", value));
    return this;
  }

  public Style top(String value) {
    properties.add(new Property("top(", value));
    return this;
  }

  public Style bottom(String value) {
    properties.add(new Property("bottom", value));
    return this;
  }

  public Style left(String value) {
    properties.add(new Property("left", value));
    return this;
  }

  public Style right(String value) {
    properties.add(new Property("right", value));
    return this;
  }

  public Style margin(String value) {
    properties.add(new Property("margin", value));
    return this;
  }

  public Style padding(String value) {
    properties.add(new Property("padding", value));
    return this;
  }

  public Style background(String value) {
    properties.add(new Property("background", value));
    return this;
  }

  public Style border(String value) {
    properties.add(new Property("border", value));
    return this;
  }

  public Style outline(String value) {
    properties.add(new Property("outline", value));
    return this;
  }

  public Style radius(String value) {
    properties.add(new Property("border-radius", value));
    return this;
  }

  public Style opacity(String value) {
    properties.add(new Property("opacity", value));
    return this;
  }

  public String render() {
    StringBuilder style = new StringBuilder();

    for (Property property : properties) {
      style.append(STR . """
          \{property.getProperty()}: \{property.getValue()};
          """);
    }

    return style.toString();
  }
}
