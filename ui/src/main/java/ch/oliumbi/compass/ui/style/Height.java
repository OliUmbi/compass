package ch.oliumbi.compass.ui.style;

public class Height implements Style {

  private final String value;

  public Height(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."height: \{value};";
  }
}
