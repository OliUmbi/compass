package ch.oliumbi.compass.server.request;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.server.cookie.Cookie;
import ch.oliumbi.compass.server.header.Header;
import ch.oliumbi.compass.server.param.Param;
import ch.oliumbi.compass.server.path.Path;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Request {

  private Path path;
  private List<Param> params;
  private Method method;
  private List<Header> headers;
  private String body;
  private List<Cookie> cookies;
}
