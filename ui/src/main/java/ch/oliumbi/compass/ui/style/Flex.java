package ch.oliumbi.compass.ui.style;

public class Flex implements Style {

  private final String direction;
  private final String wrap;
  private final String justify;
  private final String align;
  private final String gap;

  public Flex(String direction, String wrap, String justify, String align, String gap) {
    this.direction = direction;
    this.wrap = wrap;
    this.justify = justify;
    this.align = align;
    this.gap = gap;
  }

  @Override
  public String render() {
    return STR."""
        display: flex;
        flex-direction: \{direction};
        flex-wrap: \{wrap};
        justify-content: \{justify};
        align-items: \{align};
        gap: \{gap};
        """;
  }
}
