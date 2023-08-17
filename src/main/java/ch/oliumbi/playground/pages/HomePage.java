package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.annotations.North;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.playground.Playground;

@North
public class HomePage extends Playground {

  @Override
  public String path() {
    return "/";
  }

  @Override
  public String body() {
    return """
        <p>hello yxcv</p>
        """;
  }
}
