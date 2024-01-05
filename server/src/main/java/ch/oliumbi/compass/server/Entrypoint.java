package ch.oliumbi.compass.server;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.server.cookie.Cookie;
import ch.oliumbi.compass.server.header.Header;
import ch.oliumbi.compass.server.param.Param;
import ch.oliumbi.compass.server.path.Path;
import java.util.List;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;

public class Entrypoint extends Handler.Abstract {

  private final Service service = new Service();

  @Override
  public boolean handle(Request jettyRequest, Response jettyResponse, Callback callback) {
    String url = jettyRequest.getHttpURI().getDecodedPath();
    String params = jettyRequest.getHttpURI().getQuery();
    String method = jettyRequest.getMethod();
    HttpFields headers = jettyRequest.getHeaders();
    String body = BufferUtil.toString(jettyRequest.read().getByteBuffer());
    List<HttpCookie> cookies = Request.getCookies(jettyRequest);

    ch.oliumbi.compass.server.request.Request compassRequest = new ch.oliumbi.compass.server.request.Request();
    compassRequest.setPath(Path.create(url));
    compassRequest.setParams(Param.create(params));
    compassRequest.setMethod(Method.create(method));
    compassRequest.setHeaders(Header.create(headers));
    compassRequest.setBody(body);
    compassRequest.setCookies(Cookie.create(cookies));

    ch.oliumbi.compass.server.response.Response compassResponse = service.handle(compassRequest);

    jettyResponse.setStatus(compassResponse.getStatus().translate());
    for (Cookie cookie : compassResponse.getCookies()) {
      Response.addCookie(jettyResponse, cookie.build());
    }
    jettyResponse.write(true, BufferUtil.toBuffer(compassResponse.getBody()), callback);

    return true;
  }
}
