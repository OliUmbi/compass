package ch.oliumbi.compass.ui.style;

public class TextSize implements Style {

  private final String value;

  public TextSize(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."font-size: \{value};";
  }
}
