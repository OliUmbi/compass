package ch.oliumbi.compass.ui.manifest;

import ch.oliumbi.compass.core.enums.MimeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/screenshots
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Screenshot {
    private FormFactor form_factor;
    private String label;
    private String sizes;
    private String src;
    private MimeType type;
}
