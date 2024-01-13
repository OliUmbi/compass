package ch.oliumbi.compass.ui.style;

public class Bottom implements Style {

  private final String value;

  public Bottom(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."bottom: \{value};";
  }
}
