package ch.oliumbi.compass.core.cardinal;

import ch.oliumbi.compass.core.cardinal.dtos.CardinalDirectionDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class CardinalHandler extends AbstractHandler {

  private final List<CardinalDirectionDTO> routes;

  public CardinalHandler(List<CardinalDirectionDTO> routes) {
    this.routes = routes;
  }

  @Override
  public void handle(
      String target,
      Request baseRequest,
      HttpServletRequest request,
      HttpServletResponse response) throws IOException, ServletException {

    baseRequest.setHandled(true);

    CardinalDirection cardinalDirection = routes.get(0).getCardinalDirection();

    cardinalDirection.handle(request, response);



  }
}
