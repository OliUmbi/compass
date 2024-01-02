package ch.oliumbi.compass.ui.manifest;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * experimental
 * https://developer.mozilla.org/en-US/docs/Web/Manifest/share_target
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Param {
    private String title;
    private String text;
    private String url;
    private List<File> files;
}
