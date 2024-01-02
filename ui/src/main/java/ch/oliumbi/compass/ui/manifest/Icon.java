package ch.oliumbi.compass.ui.manifest;


import ch.oliumbi.compass.core.enums.MimeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/icons
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Icon {
    private String src;
    private String sizes;
    private MimeType type;
}
