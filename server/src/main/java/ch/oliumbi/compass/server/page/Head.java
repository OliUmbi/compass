package ch.oliumbi.compass.server.page;

import ch.oliumbi.compass.server.document.Document;
import ch.oliumbi.compass.server.document.Font;
import ch.oliumbi.compass.server.manifest.Manifest;
import java.util.List;

public interface Head {

  String language();
  String charset();
  String title();
  String description();
  Document icon();
  String themeColor();
  List<Font> fonts();
  List<Document> css();
  List<Document> js();

  Manifest manifest();
}
