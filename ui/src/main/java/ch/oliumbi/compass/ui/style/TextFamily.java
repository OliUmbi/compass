package ch.oliumbi.compass.ui.style;

public class TextFamily implements Style {

  private final String value;

  public TextFamily(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."font-family: \{value};";
  }
}
