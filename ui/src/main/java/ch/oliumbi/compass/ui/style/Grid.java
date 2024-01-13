package ch.oliumbi.compass.ui.style;

public class Grid implements Style {

  private final String columns;
  private final String rows;
  private final String justify;
  private final String align;
  private final String gap;

  public Grid(String columns, String rows, String justify, String align, String gap) {
    this.columns = columns;
    this.rows = rows;
    this.justify = justify;
    this.align = align;
    this.gap = gap;
  }

  @Override
  public String render() {
    return STR."""
        display: grid;
        grid-template-columns: \{columns};
        grid-template-rows: \{rows};
        justify-items: \{justify};
        align-items: \{align};
        gap: \{gap};
        """;
  }
}
