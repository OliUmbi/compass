package ch.oliumbi.compass.route;

import ch.oliumbi.compass.enums.MimeType;
import ch.oliumbi.compass.enums.Method;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Route<T> {

  String path();
  Method method();
  Class<T> mapping();

  Object handle(T body, String ip) throws Exception;
}
