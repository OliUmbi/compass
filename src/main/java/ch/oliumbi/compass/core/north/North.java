package ch.oliumbi.compass.core.north;

import ch.oliumbi.compass.core.cardinal.CardinalDirection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class North extends CardinalDirection {

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_OK);
    response.setContentType("text/html; charset=UTF-8");

    response.getWriter().print("""
        <html>
        <body>
        <p>asdkäföjklö</p>
        </body>
        </html>
        """);

  }
}
