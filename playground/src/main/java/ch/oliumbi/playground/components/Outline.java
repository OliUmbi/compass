package ch.oliumbi.playground.components;

import ch.oliumbi.compass.server.page.component.Component;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Outline extends Component {

  private final Component[] body;

  public Outline(Component... body) {
    this.body = body;
  }

  @Override
  protected String tag() {
    return "div";
  }

  @Override
  protected String body() {
    return Arrays.stream(body).map(Component::render).collect(Collectors.joining());
  }

  @Override
  protected Map<String, String> style() {
    return Map.of();
  }
}
