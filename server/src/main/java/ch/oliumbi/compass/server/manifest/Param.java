package ch.oliumbi.compass.server.manifest;

import java.util.List;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/share_target
 */
public record Param(
    String title,
    String text,
    String url,
    List<File> files
) {

}
