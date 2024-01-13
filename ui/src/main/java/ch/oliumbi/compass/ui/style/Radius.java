package ch.oliumbi.compass.ui.style;

public class Radius implements Style {

  private final String value;

  public Radius(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."border-radius: \{value};";
  }
}
