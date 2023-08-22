package ch.oliumbi.compass.document;

import ch.oliumbi.compass.enums.MimeType;

public record Document(
    String path,
    MimeType mimeType
) {

}
