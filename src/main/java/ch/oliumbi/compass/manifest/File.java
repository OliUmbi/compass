package ch.oliumbi.compass.manifest;

import java.util.List;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/share_target
 */
public record File(
    String name,
    List<String> accept
) {

}
