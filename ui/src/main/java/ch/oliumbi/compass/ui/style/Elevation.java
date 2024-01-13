package ch.oliumbi.compass.ui.style;

public class Elevation implements Style {

  private final String value;

  public Elevation(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."z-index: \{value};";
  }
}
