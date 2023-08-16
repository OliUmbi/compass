package ch.oliumbi.compass;


import ch.oliumbi.compass.annotations.North;
import ch.oliumbi.compass.route.Route;
import ch.oliumbi.compass.web.Web;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;

public abstract class Compass {

  public static void start(Class<?> clazz, String[] arguments) {
    System.out.println("Started compass");

    Reflections reflections = new Reflections(clazz.getPackageName());

    Set<Class<?>> norths = reflections.getTypesAnnotatedWith(North.class);

    for (Class<?> north : norths) {
      Constructor<?>[] declaredConstructors = north.getDeclaredConstructors();

      if (declaredConstructors.length > 1) {
        // todo too many constructors
      }

      // todo find all params
      // todo try to instantiate, ordered by params
      // todo return batch impls
      Constructor<?> constructor;
      if (declaredConstructors.length == 1) {
        constructor = declaredConstructors[0];
      }

    }

    Web web = new Web(new ArrayList<>());
    web.start();
  }
}
