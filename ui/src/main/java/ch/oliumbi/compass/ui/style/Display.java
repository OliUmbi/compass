package ch.oliumbi.compass.ui.style;

public class Display implements Style {

  private final String value;

  public Display(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."display: \{value};";
  }
}
