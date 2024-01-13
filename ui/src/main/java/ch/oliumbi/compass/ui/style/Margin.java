package ch.oliumbi.compass.ui.style;

public class Margin implements Style {

  private final String value;

  public Margin(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."margin: \{value};";
  }
}
