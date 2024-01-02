package ch.oliumbi.compass.ui.image;

import ch.oliumbi.compass.core.enums.MimeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {

  private String url;
  private MimeType type;
  private String description;
}
