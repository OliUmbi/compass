package ch.oliumbi.compass.server.page.manifest;

import ch.oliumbi.compass.core.enums.MimeType;

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
