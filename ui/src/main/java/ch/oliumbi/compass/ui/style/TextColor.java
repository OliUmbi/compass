package ch.oliumbi.compass.ui.style;

public class TextColor implements Style {

  private final String value;

  public TextColor(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."color: \{value};";
  }
}
