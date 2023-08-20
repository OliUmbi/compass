package ch.oliumbi.compass.autoload;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;

public class AutoloadService {

  public List<Object> autoload(String packageName) {
    Reflections reflections = new Reflections(packageName);

    Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Autoload.class);

    AutoloadInstantiate autoloadInstantiate = new AutoloadInstantiate();

    List<Object> instances = new ArrayList<>();
    for (Class<?> clazz : classes) {
      instances.add(autoloadInstantiate.instantiate(clazz));
    }

    return instances;
  }
}
