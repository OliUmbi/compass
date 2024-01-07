package ch.oliumbi.compass.ui.attribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {

  private String name;
  private String value;

  public String render() {
    return STR."\{name}=\"\{value}\"";
  }
}
