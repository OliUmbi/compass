package ch.oliumbi.compass.ui.style;

public class TextWeight implements Style {

  private final String value;

  public TextWeight(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."font-weight: \{value};";
  }
}
