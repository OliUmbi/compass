package ch.oliumbi.compass.core.autoload;

import ch.oliumbi.compass.core.annotations.Autoload;
import java.util.List;

public class AutoloadService {

  private final Class<?> clazz;

  public AutoloadService(Class<?> clazz) {
    this.clazz = clazz;
  }

  public List<Object> autoload() {

    Reflection reflection = new Reflection(clazz);
    List<Class<?>> classes = reflection.load();

    List<Class<?>> autoload = classes.stream().filter(aClass -> aClass.isAnnotationPresent(Autoload.class)).toList();

    AutoloadInstantiate autoloadInstantiate = new AutoloadInstantiate();
    return autoload.stream().map(autoloadInstantiate::instantiate).toList();
  }
}
