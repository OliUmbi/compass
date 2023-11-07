package ch.oliumbi.playground;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.core.enums.MimeType;
import ch.oliumbi.compass.server.file.Document;
import ch.oliumbi.compass.server.file.Font;
import ch.oliumbi.compass.server.page.manifest.Display;
import ch.oliumbi.compass.server.page.manifest.Icon;
import ch.oliumbi.compass.server.page.manifest.Manifest;
import ch.oliumbi.compass.server.page.head.Head;
import java.util.ArrayList;
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
  public Document icon() {
    return new Document("/static/images/logo.png", MimeType.PNG);
  }

  @Override
  public String themeColor() {
    return "#000000";
  }

  @Override
  public List<Font> fonts() {
    return List.of(
        new Font("Geist", "100", "/static/fonts/geist-100.woff2"),
        new Font("Geist", "200", "/static/fonts/geist-200.woff2"),
        new Font("Geist", "300", "/static/fonts/geist-300.woff2"),
        new Font("Geist", "400", "/static/fonts/geist-400.woff2"),
        new Font("Geist", "500", "/static/fonts/geist-500.woff2"),
        new Font("Geist", "600", "/static/fonts/geist-600.woff2"),
        new Font("Geist", "700", "/static/fonts/geist-700.woff2"),
        new Font("Geist", "800", "/static/fonts/geist-800.woff2"),
        new Font("Geist", "900", "/static/fonts/geist-900.woff2")
    );
  }

  @Override
  public List<Document> css() {
    return List.of(
        new Document("/static/styles/default.css", MimeType.CSS)
    );
  }

  @Override
  public List<Document> js() {
    return new ArrayList<>();
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
            new Icon("/static/images/logo.png", "1000x1000", MimeType.PNG)
        )
    );
  }
}
