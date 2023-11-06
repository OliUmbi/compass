package ch.oliumbi.compass.server.document;

public record Font(
    String name,
    String weight,
    String path
) {

  @Override
  public String toString() {

    return String.format("""  
            @font-face {
              font-family: '%s';
              font-weight: %s;
              font-style: normal;
              font-display: swap;
              src: url(%s);
            }
            """,
        name,
        weight,
        path);
  }
}
