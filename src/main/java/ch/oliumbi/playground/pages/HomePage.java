package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.playground.Main;
import ch.oliumbi.playground.Playground;
import ch.oliumbi.playground.SomeService;

@Autoload
public class HomePage extends Playground {

  private SomeService someService;

  public HomePage(SomeService someService) {
    this.someService = someService;
    someService.test();
  }

  @Override
  public String path() {
    return "/";
  }

  @Override
  public String body() {
    someService.test();

    return """
        <p>hello yxcv</p>
        """;
  }
}
