//package ch.oliumbi.compass.server;
//
//import ch.oliumbi.compass.core.Compass;
//import ch.oliumbi.compass.server.file.Font;
//import ch.oliumbi.compass.server.page.head.DefaultHead;
//import ch.oliumbi.compass.server.page.head.Head;
//import ch.oliumbi.compass.server.page.Page;
//import ch.oliumbi.compass.server.route.Route;
//import ch.oliumbi.compass.core.enums.Method;
//import ch.oliumbi.compass.core.enums.MimeType;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.eclipse.jetty.server.Request;
//import org.eclipse.jetty.server.Response;
//import org.eclipse.jetty.server.handler.AbstractHandler;
//import org.eclipse.jetty.util.Callback;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class ServerHandler extends AbstractHandler {
//
//  public static final Logger LOGGER = LoggerFactory.getLogger(ServerHandler.class);
//
//  private final ObjectMapper objectMapper = new ObjectMapper();
//  private final List<Page> pages = new ArrayList<>();
//  private final List<Route> routes = new ArrayList<>();
//  private Head head = new DefaultHead();
//
//  public ServerHandler() {
//
//    pages.addAll(Compass.instances(Page.class));
//    routes.addAll(Compass.instances(Route.class));
//
//    for (Head instance : Compass.instances(Head.class)) {
//      head = instance;
//    }
//  }
//
//  @Override
//  public boolean handle(Request request, Response response, Callback callback) throws Exception {
//
//    response.setHeader("Access-Control-Allow-Origin", "*");
//    response.setHeader("Access-Control-Allow-Credentials", "true");
//
//    System.out.println(request.getPathInfo());
//    System.out.println(request.getParameterMap());
//    System.out.println(request.getMethod());
//    try {
//      System.out.println(request.getReader().lines().collect(Collectors.joining()));
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    };
//
//    try {
//
//      if (target.startsWith("/static")) {
//
//        InputStream resourceAsStream = Compass.resource(target).openStream();
//
//        response.getOutputStream().write(resourceAsStream.readAllBytes());
//      }
//
//      if (target.equals("/manifest.json")) {
//
//        response.setContentType(MimeType.JSON.translate());
//        response.getOutputStream().print(objectMapper.writeValueAsString(head.manifest()));
//      }
//
//      if (target.equals("/fonts.css")) {
//
//        response.setContentType(MimeType.CSS.translate());
//        response.getOutputStream().print(head.fonts().stream().map(Font::toString).collect(Collectors.joining()));
//      }
//
//      if (request.getMethod().equals(Method.GET.name())) {
//        for (Page page : pages) {
//
//          if (page.path().equals(target)) {
//
//            String html = String.format("""
//                    <!doctype html>
//                    <html lang="%s">
//                    <head>
//                      <meta charset="%s">
//                      <title>%s</title>
//                      <meta name="description" content="%s">
//                      <meta name="theme-color" content="%s">
//                      <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
//                      <meta http-equiv="X-UA-Compatible" content="ie=edge">
//                      <link rel="icon" href="%s" type="%s">
//                      <link rel="manifest" href="manifest.json" />
//                      <link rel="stylesheet" href="fonts.css" />
//                      %s
//                      %s
//                    </head>
//                    <body>
//                    """,
//                head.language(),
//                head.charset(),
//                head.title(),
//                head.description(),
//                head.themeColor(),
//                head.icon().path(),
//                head.icon().mimeType().translate(),
//                head.css().stream()
//                    .map(document -> "<link rel=\"stylesheet\" href=\"" + document.path() + "\" />")
//                    .collect(Collectors.joining()),
//                head.js().stream()
//                    .map(document -> "<script src=\"" + document.path() + "\"></script>")
//                    .collect(Collectors.joining())
//            );
//
//            html += page.body().render();
//
//            html += """
//                </body>
//                </html>
//                """;
//
//            response.setContentType(MimeType.HTML.translate());
//            response.getOutputStream().print(html);
//          }
//        }
//      }
//
//      for (Route route : routes) {
//
//        if (route.path().equals(target)
//            && route.method().name().equals(request.getMethod())) {
//
//
//          String requestBody = request.getReader().lines().collect(Collectors.joining());
//
//          Object body = null;
//          if (!requestBody.isEmpty()){
//            body = objectMapper.readValue(requestBody, route.mapping());
//          }
//
//          response.setContentType(MimeType.JSON.translate());
//          response.getOutputStream().print(objectMapper.writeValueAsString(route.handle(body)));
//        }
//      }
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      // todo handle exception
//      LOGGER.error("Failed to handle request", e);
//    }
//
//    return true;
//  }
//}
