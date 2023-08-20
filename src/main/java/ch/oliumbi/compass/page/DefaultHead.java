package ch.oliumbi.compass.page;

import ch.oliumbi.compass.manifest.Display;
import ch.oliumbi.compass.manifest.Manifest;
import java.util.ArrayList;

public class DefaultHead implements Head {

  @Override
  public String language() {
    return "en";
  }

  @Override
  public String charset() {
    return "utf-8";
  }

  @Override
  public String title() {
    return "undefined";
  }

  @Override
  public String description() {
    return "undefined";
  }

  @Override
  public String iconHref() {
    return "undefined";
  }

  @Override
  public String themeColor() {
    return "#000000";
  }

  @Override
  public Manifest manifest() {
    return new Manifest(
        "undefined",
        "undefined",
        "undefined",
        "#ffffff",
        "#000000",
        Display.MINIMAL_UI,
        new ArrayList<>()
    );
  }
}
