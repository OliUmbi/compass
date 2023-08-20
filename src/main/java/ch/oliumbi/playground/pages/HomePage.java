package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.playground.Main;
import ch.oliumbi.playground.Playground;
import ch.oliumbi.playground.SomeService;

@Autoload
public class HomePage implements Page {

  private SomeService someService;

  public HomePage(SomeService someService) {
    this.someService = someService;
  }

  @Override
  public String path() {
    return "/";
  }

  @Override
  public String body() {
    someService.test();

    return """
        <p>hello world</p>
        """;
  }
}
