package ch.oliumbi.compass.ui.style;

public class HeightMax implements Style {

  private final String value;

  public HeightMax(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."max-height: \{value};";
  }
}
