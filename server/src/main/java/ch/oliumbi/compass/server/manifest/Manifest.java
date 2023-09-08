package ch.oliumbi.compass.server.manifest;

import java.util.ArrayList;
import java.util.List;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Manifest
 */
public record Manifest(
    String name,
    String short_name,
    String description,
    String background_color,
    String theme_color,
    Display display,
    List<Icon> icons,
    String start_url,
    List<Screenshot> screenshots,
    List<Shortcut> shortcuts,
    List<Category> categories,
    ShareTarget share_target,
    String scope,
    Orientation orientation
) {

  public Manifest(
      String name,
      String short_name,
      String description,
      String background_color,
      String theme_color,
      Display display,
      List<Icon> icons) {
    this(
        name,
        short_name,
        description,
        background_color,
        theme_color,
        display,
        icons,
        "/",
        new ArrayList<>(),
        new ArrayList<>(),
        new ArrayList<>(),
        null,
        "/",
        Orientation.ANY
    );
  }
}
