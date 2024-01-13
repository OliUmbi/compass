package ch.oliumbi.compass.ui.style;

public class Outline implements Style {

  private final String value;

  public Outline(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."outline: \{value};";
  }
}
