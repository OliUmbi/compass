package ch.oliumbi.compass.server.document;

public record Font(
    String name,
    String path,
    String format,
    String weight
) {

  public Font(String name, String path, String format) {
    this(name, path, format, null);
  }

  @Override
  public String toString() {
    String fontFace = String.format("""  
            @font-face {
              font-family: %s;
              font-style: normal;
              font-display: swap;
              src: url(%s) format(%s);
            """,
        name,
        path,
        format);

    if (weight != null) {
      fontFace += String.format("""
            font-weight: %s;
          """, weight);
    }

    fontFace += """
        }
        """;

    return fontFace;
  }
}
