package ch.oliumbi.user;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.compass.document.Document;
import ch.oliumbi.compass.document.Font;
import ch.oliumbi.compass.enums.MimeType;
import ch.oliumbi.compass.manifest.Display;
import ch.oliumbi.compass.manifest.Icon;
import ch.oliumbi.compass.manifest.Manifest;
import ch.oliumbi.compass.page.Head;
import java.util.ArrayList;
import java.util.List;

@Autoload
public class User implements Head {

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
    return "User";
  }

  @Override
  public String description() {
    return "User message board";
  }

  @Override
  public Document icon() {
    return new Document("/static/images/img.png", MimeType.PNG);
  }

  @Override
  public String themeColor() {
    return "#000000";
  }

  @Override
  public List<Font> fonts() {
    return List.of(
        new Font("'Inter'", "/static/fonts/inter.ttf", "'truetype'"),
        new Font("'Inter'", "/static/fonts/inter-300.woff2", "'woff2'", "300"),
        new Font("'Inter'", "/static/fonts/inter-400.woff2", "'woff2'", "400"),
        new Font("'Inter'", "/static/fonts/inter-500.woff2", "'woff2'", "500"),
        new Font("'Inter'", "/static/fonts/inter-600.woff2", "'woff2'", "600"),
        new Font("'Inter'", "/static/fonts/inter-700.woff2", "'woff2'", "700")
    );
  }

  @Override
  public List<Document> css() {
    return List.of(
        new Document("/static/css/normalize.css", MimeType.CSS),
        new Document("/static/css/style.css", MimeType.CSS)
    );
  }

  @Override
  public List<Document> js() {
    return List.of(
        new Document("/static/js/script.js", MimeType.JAVASCRIPT)
    );
  }

  @Override
  public Manifest manifest() {
    return new Manifest(
        "User",
        "User",
        "User message board",
        "#ffffff",
        "#000000",
        Display.MINIMAL_UI,
        new ArrayList<>()
    );
  }
}
