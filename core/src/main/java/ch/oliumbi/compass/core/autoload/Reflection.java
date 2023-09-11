package ch.oliumbi.compass.core.autoload;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Reflection {

  private final Class<?> clazz;

  public Reflection(Class<?> clazz) {
    this.clazz = clazz;
  }

  public List<Class<?>> load() {
    ClassLoader classLoader = clazz.getClassLoader();
    String packageName = clazz.getPackageName();

    return loadPackage(classLoader, packageName);
  }

  private List<Class<?>> loadPackage(ClassLoader classLoader, String packageName) {
    List<Class<?>> classes = new ArrayList<>();

    for (String file : getFiles(classLoader, packageName)) {

      if (file.endsWith(".class")) {
        classes.add(getClass(file, packageName));
        continue;
      }
      if (file.contains(".")) {
        System.out.println("what?");
        continue;
      }

      classes.addAll(loadPackage(classLoader, packageName + "." + file));
    }

    return classes;
  }

  private List<String> getFiles(ClassLoader classLoader, String packageName) {
    InputStream inputStream = classLoader.getResourceAsStream(packageName.replaceAll("[.]", "/"));

    if (inputStream == null) {
      return Collections.emptyList();
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    return reader.lines().toList();
  }

  private Class<?> getClass(String className, String packageName) {
    try {
      return Class.forName(packageName + "."
          + className.substring(0, className.lastIndexOf('.')));
    } catch (ClassNotFoundException e) {
      // handle the exception
    }
    return null;
  }
}