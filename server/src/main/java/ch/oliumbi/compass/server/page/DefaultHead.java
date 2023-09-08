package ch.oliumbi.compass.server.page;

import ch.oliumbi.compass.server.document.Document;
import ch.oliumbi.compass.server.document.Font;
import ch.oliumbi.compass.server.manifest.Display;
import ch.oliumbi.compass.server.manifest.Manifest;
import java.util.ArrayList;
import java.util.List;

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
  public Document icon() {
    return new Document("undefined", null);
  }

  @Override
  public String themeColor() {
    return "#000000";
  }

  @Override
  public List<Font> fonts() {
    return new ArrayList<>();
  }

  @Override
  public List<Document> css() {
    return new ArrayList<>();
  }

  @Override
  public List<Document> js() {
    return new ArrayList<>();
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
