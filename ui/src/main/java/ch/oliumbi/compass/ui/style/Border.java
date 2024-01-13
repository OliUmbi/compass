package ch.oliumbi.compass.ui.style;

public class Border implements Style {

  private final String value;

  public Border(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."border: \{value};";
  }
}
