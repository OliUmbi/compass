package ch.oliumbi.compass.page;

import ch.oliumbi.compass.manifest.Manifest;

public interface Head {

  String language();
  String charset();
  String title();
  String description();
  String iconHref();
  String themeColor();

  Manifest manifest();
}
