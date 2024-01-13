package ch.oliumbi.compass.ui.style;

public class Fit implements Style {

  private final String value;

  public Fit(String value) {
    this.value = value;
  }

  @Override
  public String render() {
    return STR."object-fit: \{value};";
  }
}
