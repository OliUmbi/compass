package ch.oliumbi.compass;


import ch.oliumbi.compass.annotations.North;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.compass.route.Route;
import ch.oliumbi.compass.web.Web;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;

public abstract class Compass {

  public static void start(Class<?> clazz, String[] arguments) {
    System.out.println("Started compass");

    Reflections reflections = new Reflections(clazz.getPackageName());

    Set<Class<?>> norths = reflections.getTypesAnnotatedWith(North.class);

    List<Page> pages = new ArrayList<>();
    for (Class<?> north : norths) {
      Object instance = createInstance(north);

      if (instance instanceof Page page) {
        pages.add(page);
      }
    }

    Web web = new Web(pages);
    web.start();
  }


  public static <T> T createInstance(Class<T> clazz) {
    Constructor<T> constructor;
    try {
      constructor = clazz.getConstructor();
    } catch (NoSuchMethodException e) {
      System.out.println("No constructor found for class " + clazz.getName());
      throw new RuntimeException();
    }

    try {
      return constructor.newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      System.out.println("Failed to instantiate / create class " + clazz.getName());
      throw new RuntimeException();
    }
  }
}
