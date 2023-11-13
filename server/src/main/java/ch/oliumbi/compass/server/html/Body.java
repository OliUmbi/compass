package ch.oliumbi.compass.server.html;

public class Body implements Renderable {

  @Override
  public String render() {
    return """
        <body>
        </body>
        """;
  }
}
