package ch.oliumbi.compass.autoload;

import java.util.List;

public class AutoloadService {

  private final Class<?> clazz;

  public AutoloadService(Class<?> clazz) {
    this.clazz = clazz;
  }

  public List<Object> autoload() {

    Reflection reflection = new Reflection(clazz);
    List<Class<?>> classes = reflection.load();

    AutoloadInstantiate autoloadInstantiate = new AutoloadInstantiate();
    return classes.stream().map(autoloadInstantiate::instantiate).toList();
  }
}
