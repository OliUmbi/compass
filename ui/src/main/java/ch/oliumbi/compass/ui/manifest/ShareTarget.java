package ch.oliumbi.compass.ui.manifest;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.MimeType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * experimental https://developer.mozilla.org/en-US/docs/Web/Manifest/share_target
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShareTarget {

  private String action;
  private Method method;
  private MimeType enctype;
  private List<Param> params;
}
