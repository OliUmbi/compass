package ch.oliumbi.compass.ui.style;

public class WidthMax implements Style {

  private final String value;

  public WidthMax(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."max-width: \{value};";
  }
}
