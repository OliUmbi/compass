package ch.oliumbi.compass.ui.font;

import ch.oliumbi.compass.core.enums.MimeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Font {

  private String name;
  private String url;
  private MimeType type;

  public String render() {
    return STR."""
          @font-face {
            font-family: "\{name}";
            font-display: swap;
            src: url(\{url}) format("\{type.translate()}");
          }
          """;
  }
}
