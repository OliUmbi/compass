package ch.oliumbi.compass.server.response;

import ch.oliumbi.compass.core.enums.MimeType;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.server.cookie.Cookie;
import ch.oliumbi.compass.server.header.Header;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {

  private Status status;
  private MimeType type;
  private List<Header> headers;
  private List<Cookie> cookies;
  private byte[] body;
}
