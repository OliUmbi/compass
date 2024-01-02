package ch.oliumbi.compass.ui.manifest;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * experimental https://developer.mozilla.org/en-US/docs/Web/Manifest/shortcuts
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shortcut {

  private String name;
  private String short_name;
  private String description;
  private String url;
  private List<Icon> icons;
}
