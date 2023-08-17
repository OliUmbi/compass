package ch.oliumbi.compass.page;

import ch.oliumbi.compass.manifest.Manifest;
import java.util.List;

public interface Page {


  String path();
  Head head();
  Manifest manifest();
  String language();
  String icon();
  String body();
}
