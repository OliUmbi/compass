package ch.oliumbi.compass.ui.style;

public class Opacity implements Style {

  private final String value;

  public Opacity(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."opacity: \{value};";
  }
}
