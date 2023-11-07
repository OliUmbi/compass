package ch.oliumbi.compass.server.file;

import ch.oliumbi.compass.core.enums.MimeType;

public record Document(
    String path,
    MimeType mimeType
) {

}
