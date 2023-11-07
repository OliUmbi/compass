package ch.oliumbi.compass.server.page.head;

import ch.oliumbi.compass.server.file.Document;
import ch.oliumbi.compass.server.file.Font;
import ch.oliumbi.compass.server.page.manifest.Manifest;
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
