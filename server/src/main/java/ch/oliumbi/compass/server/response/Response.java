package ch.oliumbi.compass.server.response;

import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.server.cookie.Cookie;
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
  private List<Cookie> cookies;
  private byte[] body;

  public void setBody(byte[] body) {
    this.body = body;
  }

  public void setBody(String body) {
    this.body = body.getBytes();
  }
}
