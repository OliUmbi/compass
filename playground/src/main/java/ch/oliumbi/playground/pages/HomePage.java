package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.page.Page;
import ch.oliumbi.playground.YeetService;

@Autoload
public class HomePage implements Page {

  private final YeetService yeetService;

  public HomePage(YeetService yeetService) {
    this.yeetService = yeetService;
  }

  @Override
  public String path() {
    return "/";
  }

  @Override
  public String body() {

    yeetService.yeet();

    return """
        <p style="font-family: 'Inter';">hello world</p>
        """;
  }
}
