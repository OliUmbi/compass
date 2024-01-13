package ch.oliumbi.compass.ui.style;

public class Overflow implements Style {

  private final String value;

  public Overflow(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."overflow: \{value};";
  }
}
