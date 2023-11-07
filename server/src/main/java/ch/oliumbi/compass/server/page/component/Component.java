package ch.oliumbi.compass.server.page.component;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class Component {

  protected abstract String tag();

  protected abstract String body();

  protected abstract Map<String, String> style();

  public String render() {
    return String.format("<%s style=\"%s\">%s</%s>", tag(), renderStyle(), body(), tag());
  }

  private String renderStyle() {

    return style()
        .entrySet()
        .stream()
        .map(style -> String.format("%s: %s;", style.getKey(), style.getValue()))
        .collect(Collectors.joining());
  }
}
