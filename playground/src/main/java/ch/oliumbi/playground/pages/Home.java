package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.page.Page;

@Autoload
public class Home implements Page {

  @Override
  public String path() {
    return "/";
  }

  @Override
  public String body() {
    return """
        <h1>Hello World!</h1>
        """;
  }
}
