package ch.oliumbi.compass.ui.style;

public class Top implements Style {

  private final String value;

  public Top(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."top: \{value};";
  }
}
