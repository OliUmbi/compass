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
public class File {

  private String name;
  private List<String> accept;
}
