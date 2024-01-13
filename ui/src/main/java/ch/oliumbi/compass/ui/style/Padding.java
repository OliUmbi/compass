package ch.oliumbi.compass.ui.style;

public class Padding implements Style {

  private final String value;

  public Padding(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."padding: \{value};";
  }
}
