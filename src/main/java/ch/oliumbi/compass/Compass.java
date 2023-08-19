package ch.oliumbi.compass;


import ch.oliumbi.compass.autoload.AutoloadService;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.compass.web.Web;
import java.util.ArrayList;
import java.util.List;

public abstract class Compass {

  public static void start(Class<?> clazz, String[] arguments) {
    System.out.println("Started compass");

    AutoloadService autoloadService = new AutoloadService();

    List<Object> instances = autoloadService.autoload(clazz.getPackageName());

    System.out.println(instances);

    List<Page> pages = new ArrayList<>();
    for (Object instance : instances) {
      if (instance instanceof Page page) {
        pages.add(page);
      }
    }

    Web web = new Web(pages);
    web.start();
  }


}
