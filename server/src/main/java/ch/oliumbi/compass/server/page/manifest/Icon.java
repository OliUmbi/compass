package ch.oliumbi.compass.server.page.manifest;


import ch.oliumbi.compass.core.enums.MimeType;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/icons
 */
public record Icon(
    String src,
    String sizes,
    MimeType type
) {

}
