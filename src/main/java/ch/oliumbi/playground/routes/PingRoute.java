package ch.oliumbi.playground.routes;

import ch.oliumbi.compass.enums.Method;
import ch.oliumbi.compass.route.Route;

public class PingRoute implements Route<PingRequest> {

  @Override
  public String path() {
    return "/ping";
  }

  @Override
  public Method method() {
    return Method.POST;
  }

  @Override
  public Class<PingRequest> mapping() {
    return PingRequest.class;
  }

  @Override
  public Object handle(PingRequest body) throws Exception {
    return new PingResponse(body.message() + " pong");
  }
}
