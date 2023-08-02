package ch.oliumbi.compass.core.cardinal;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class CardinalDirection {

  public abstract void handle(HttpServletRequest request, HttpServletResponse response);

}
