package ch.oliumbi.compass.ui.style;

public class Width implements Style {

  private final String value;

  public Width(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."width: \{value};";
  }
}
