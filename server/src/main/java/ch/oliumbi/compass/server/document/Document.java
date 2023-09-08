package ch.oliumbi.compass.server.document;

import ch.oliumbi.compass.core.enums.MimeType;

public record Document(
    String path,
    MimeType mimeType
) {

}
