package ch.oliumbi.compass.ui.style;

public class WidthMin implements Style {

  private final String value;

  public WidthMin(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."min-width: \{value};";
  }
}
