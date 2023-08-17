package ch.oliumbi.compass.web;

import ch.oliumbi.compass.enums.MimeType;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.playground.Main;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class WebHandler extends AbstractHandler {

  private final List<Page> pages;

  public WebHandler(List<Page> pages) {
    this.pages = pages;
  }

  @Override
  public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {

    baseRequest.setHandled(true);

    try {

      if (target.startsWith("/static")) {

        InputStream resourceAsStream = Main.class.getResourceAsStream(target);

        response.getOutputStream().write(resourceAsStream.readAllBytes());
      }

      for (Page page : pages) {

        if (page.path().equals(target)) {

          response.setContentType(MimeType.HTML.translate());

          String html = String.format("""
                  <!doctype html>
                  <html lang="%s">
                  <head>
                    <meta charset="%s">
                    <title>%s</title>
                    <meta name="description" content="%s">
                    <meta name="theme-color" content="%s">
                    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <link rel="icon" href="%s">
                  </head>
                  <body>
                  """,
              page.head().language(),
              page.head().charset(),
              page.head().title(),
              page.head().description(),
              page.head().themeColor(),
              page.head().iconHref()
          );

          html += page.body();

          html += """
              </body>
              </html>
              """;

          response.getOutputStream().print(html);
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
      // todo handle exception
    }

  }
}
