package ch.oliumbi.compass.server.cookie;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.HttpCookie.SameSite;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cookie {

  private String name;
  private String value;
  private long maxAge;

  public static List<Cookie> create(List<HttpCookie> httpCookies) {
    List<Cookie> cookies = new ArrayList<>();

    for (HttpCookie httpCookie : httpCookies) {
      cookies.add(new Cookie(httpCookie.getName(), httpCookie.getValue(), httpCookie.getMaxAge()));
    }

    return cookies;
  }

  public HttpCookie build() {
    return HttpCookie.build(name, value)
            .path("/")
            .sameSite(SameSite.STRICT)
            .secure(true)
            .maxAge(maxAge)
            .build();
  }
}
