package ch.oliumbi.compass.ui.style;

public class Background implements Style {

  private final String value;

  public Background(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."background: \{value};";
  }
}
