package ch.oliumbi.compass.ui.style;

public class Right implements Style {

  private final String value;

  public Right(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."right: \{value};";
  }
}
