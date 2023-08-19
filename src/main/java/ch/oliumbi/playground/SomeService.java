package ch.oliumbi.playground;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.playground.pages.HomePage;

@Autoload
public class SomeService {


  private String test = "it worked";

  public void test() {
    System.out.println(test);
  }

}
