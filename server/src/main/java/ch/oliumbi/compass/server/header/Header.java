package ch.oliumbi.compass.server.header;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Header {

  private String name;
  private String value;

  public static List<Header> create(HttpFields httpFields) {
    List<Header> headers = new ArrayList<>();

    for (HttpField httpField : httpFields) {
      headers.add(new Header(httpField.getName(), httpField.getValue()));
    }

    return headers;
  }
}
