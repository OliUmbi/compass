package ch.oliumbi.compass.ui.style;

public class TextAlign implements Style {

  private final String value;

  public TextAlign(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."text-align: \{value};";
  }
}
