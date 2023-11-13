package ch.oliumbi.compass.server.file;

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

  // todo rethink complex constructs, maybe standardized for png and stuff like that
}
