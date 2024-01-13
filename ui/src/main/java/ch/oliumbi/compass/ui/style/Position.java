package ch.oliumbi.compass.ui.style;

public class Position implements Style {

  private final String value;

  public Position(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."position: \{value};";
  }
}
