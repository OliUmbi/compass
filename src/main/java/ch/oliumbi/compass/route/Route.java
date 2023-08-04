package ch.oliumbi.compass.route;

import ch.oliumbi.compass.enums.ContentType;
import ch.oliumbi.compass.enums.Method;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Route {

  String path();
  Method method();
  ContentType contentType();

  Object handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
