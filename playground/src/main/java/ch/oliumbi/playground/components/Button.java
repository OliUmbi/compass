package ch.oliumbi.playground.components;

import ch.oliumbi.compass.server.page.component.Component;
import java.util.Map;

public class Button extends Component {

  private final String body;
  private final String color;

  public Button(String body, String color) {
    this.body = body;
    this.color = color;
  }

  @Override
  protected String tag() {
    return "button";
  }

  @Override
  protected String body() {
    return body;
  }

  @Override
  protected Map<String, String> style() {
    return Map.of(
        "background-color", color
    );
  }
}
