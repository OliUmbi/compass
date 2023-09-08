package ch.oliumbi.compass.server.manifest;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.MimeType;
import java.util.List;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/share_target
 */
public record ShareTarget(
    String action,
    Method method,
    MimeType enctype,
    List<Param> params
) {

}
