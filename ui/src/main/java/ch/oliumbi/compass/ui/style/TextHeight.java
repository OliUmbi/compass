package ch.oliumbi.compass.ui.style;

public class TextHeight implements Style {

  private final String value;

  public TextHeight(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."line-height: \{value};";
  }
}
