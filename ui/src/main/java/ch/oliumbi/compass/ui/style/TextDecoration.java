package ch.oliumbi.compass.ui.style;

public class TextDecoration implements Style {

  private final String value;

  public TextDecoration(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."text-decoration: \{value};";
  }
}
