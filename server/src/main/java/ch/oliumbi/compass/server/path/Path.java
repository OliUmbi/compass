package ch.oliumbi.compass.server.path;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Path {

  private String url;
  private String pattern;

  public static Path create(String url) {
    Path path = new Path();
    path.setUrl(url);

    return path;
  }

  /**
   * **     does not matter continue * + :  has to be at least 1 text   has to match exactly pattern end
   */

  public boolean matches() {
    String[] patterns = pattern.split("/");
    String[] urls = url.split("/");

    int patternPointer = 0;
    int urlPointer = 0;

    while (patternPointer < patterns.length && urlPointer < urls.length) {
      String pattern = patterns[patternPointer];
      String url = urls[urlPointer];

      if ("**".equals(pattern)) {
        return true;
      }

      if (!match(pattern, url)) {
        return false;
      }

      patternPointer++;
      urlPointer++;
    }

    if (patternPointer != patterns.length) {
      return false;
    }

    if (urlPointer != urls.length) {
      return false;
    }

    return true;
  }

  private boolean match(String pattern, String url) {
    if (pattern.equals("*") && !url.isBlank()) {
      return true;
    }

    if (pattern.startsWith(":") && !url.isBlank()) {
      return true;
    }

    if (pattern.equals(url)) {
      return true;
    }

    return false;
  }

  public String element(String name) {

    String[] patterns = pattern.split("/");
    String[] urls = url.split("/");

    int patternPointer = 0;
    int urlPointer = 0;

    while (patternPointer < patterns.length && urlPointer < urls.length) {
      String pattern = patterns[patternPointer];
      String url = urls[urlPointer];

      if (pattern.equals(":" + name)) {
        return url;
      }

      patternPointer++;
      urlPointer++;
    }

    return null;
  }
}
