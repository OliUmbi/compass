package ch.oliumbi.compass.ui.style;

public class HeightMin implements Style {

  private final String value;

  public HeightMin(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."min-height: \{value};";
  }
}
