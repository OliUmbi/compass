package ch.oliumbi.compass.manifest;

import ch.oliumbi.compass.enums.MimeType;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/screenshots
 */
public record Screenshot(
    FormFactor form_factor,
    String label,
    String sizes,
    String src,
    MimeType type
    ) {

}
