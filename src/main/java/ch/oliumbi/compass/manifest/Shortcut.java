package ch.oliumbi.compass.manifest;

import java.util.List;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/shortcuts
 */
public record Shortcut(
    String name,
    String short_name,
    String description,
    String url,
    List<Icon> icons
) {

}
