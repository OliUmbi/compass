package ch.oliumbi.playground;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.compass.enums.MimeType;
import ch.oliumbi.compass.manifest.Display;
import ch.oliumbi.compass.manifest.Icon;
import ch.oliumbi.compass.manifest.Manifest;
import ch.oliumbi.compass.page.Head;
import java.util.List;

@Autoload
public class Playground implements Head {

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
    return "Playground";
  }

  @Override
  public String description() {
    return "Compass testing grounds";
  }

  @Override
  public String iconHref() {
    return "/static/images/img.png";
  }

  @Override
  public String themeColor() {
    return "#000000";
  }

  @Override
  public Manifest manifest() {
    return new Manifest(
        "Playground",
        "plygrnd",
        "Compass testing grounds",
        "#ffffff",
        "#000000",
        Display.MINIMAL_UI,
        List.of(
            new Icon("/static/images/logo.png", "2000x2000", MimeType.PNG),
            new Icon("/static/images/logo-small.png", "144x144", MimeType.PNG)
        )
    );
  }
}
