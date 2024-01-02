package ch.oliumbi.compass.server.param;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Param {

  private String name;
  private String value;

  public static List<Param> create(String string) {
    List<Param> params = new ArrayList<>();

    if (string == null) {
      return params;
    }

    String[] stringParams = string.split("&");
    for (String stringParam : stringParams) {
      String[] pair = stringParam.split("=");
      params.add(new Param(pair[0], pair[1]));
    }

    return params;
  }
}
