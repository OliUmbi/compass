package ch.oliumbi.compass.route;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Route {

  String url();
  String method();
  String contentType();

  Object handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
