package ch.oliumbi.playground;

import ch.oliumbi.compass.manifest.Display;
import ch.oliumbi.compass.manifest.Manifest;
import ch.oliumbi.compass.page.Head;
import ch.oliumbi.compass.page.Page;
import java.util.ArrayList;

public abstract class Playground implements Page {

  @Override
  public Head head() {
    return new Head(
        "en",
        "utf-8",
        "Playground",
        "Compass testing grounds",
        "/static/images/img.png",
        "#000000"
    );
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
        new ArrayList<>()
    );
  }
}
