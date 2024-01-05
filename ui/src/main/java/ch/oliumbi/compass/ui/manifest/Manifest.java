package ch.oliumbi.compass.ui.manifest;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * https://developer.mozilla.org/en-US/docs/Web/Manifest
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manifest {
  private String name;
  private String short_name;
  private String description;
  private String background_color;
  private String theme_color;
  private Display display;
  private List<Icon> icons;
  private String start_url;
  private List<Screenshot> screenshots;
  private List<Shortcut> shortcuts;
  private List<Category> categories;
  private ShareTarget share_target;
  private String scope;
  private Orientation orientation;
}
