package ch.oliumbi.compass.core.autoload;

import ch.oliumbi.compass.core.annotations.Autoload;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoloadService {

  public static final Logger LOGGER = LoggerFactory.getLogger(AutoloadService.class);

  private final Class<?> clazz;

  public AutoloadService(Class<?> clazz) {
    this.clazz = clazz;
  }

  public List<Object> autoload() {

    List<Class<?>> classes = load();

    List<Class<?>> autoload = classes.stream().filter(aClass -> aClass.isAnnotationPresent(Autoload.class)).toList();

    AutoloadInstantiate autoloadInstantiate = new AutoloadInstantiate();
    return autoload.stream().map(autoloadInstantiate::instantiate).toList();
  }

  public List<Class<?>> load() {

    ClassLoader classLoader = clazz.getClassLoader();
    String packageName = clazz.getPackageName();

    try {
      Class<?> aClass = classLoader.loadClass("ch.oliumbi.playground.Home");

      Arrays.stream(aClass.getDeclaredAnnotations()).forEach(System.out::println);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    return loadPackage(classLoader, packageName);
  }

  private List<Class<?>> loadPackage(ClassLoader classLoader, String packageName) {

    List<Class<?>> classes = new ArrayList<>();

    for (String file : getFiles(classLoader, packageName)) {

      System.out.println(file);

      if (file.endsWith(".class")) {
        classes.add(getClass(file, packageName));
        continue;
      }

      if (file.contains(".")) {
        LOGGER.warn("Found non class files, file " + file);
        continue;
      }

      classes.addAll(loadPackage(classLoader, packageName + "." + file));
    }

    return classes;
  }

  private List<String> getFiles(ClassLoader classLoader, String packageName) {
    InputStream inputStream = classLoader.getResourceAsStream(packageName.replaceAll("[.]", "/"));

    if (inputStream == null) {
      LOGGER.warn("Failed to get package files, package " + packageName);
      return Collections.emptyList();
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    return reader.lines().toList();
  }

  private Class<?> getClass(String className, String packageName) {
    try {
      return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
    } catch (ClassNotFoundException e) {
      LOGGER.warn("Failed to load class, name " + className, e);
    }
    return null;
  }
}
