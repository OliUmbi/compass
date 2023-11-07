package ch.oliumbi.compass.server.path;

import java.util.List;

public class Path {

  private List<String> parts; // todo change to custom object with possibility for dynamic
  private List<String> queries; // todo change to custom object

  public Path(String url) {

  }

  public boolean matches(Path path) {
    return true;
  }
}
