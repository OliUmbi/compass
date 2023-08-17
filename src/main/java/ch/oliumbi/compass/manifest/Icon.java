package ch.oliumbi.compass.manifest;

import ch.oliumbi.compass.enums.MimeType;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/icons
 */
public record Icon(
    String src,
    String sizes,
    MimeType type
) {

}
