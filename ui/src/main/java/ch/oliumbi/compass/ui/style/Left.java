package ch.oliumbi.compass.ui.style;

public class Left implements Style {

  private final String value;

  public Left(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."left: \{value};";
  }
}
