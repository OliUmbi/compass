package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.page.Page;

@Autoload
public class HomePage implements Page {

  @Override
  public String path() {
    return "/";
  }

  @Override
  public String body() {

    return """
        <main>
          <h1>Selektionstag 15.09.2023</h1>
          <p>Es hat funktioniert</p>
        </main>
        """;
  }
}
