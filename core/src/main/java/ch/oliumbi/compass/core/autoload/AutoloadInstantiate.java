package ch.oliumbi.compass.core.autoload;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class AutoloadInstantiate {

  private final List<Object> instances = new ArrayList<>();

  public Object instantiate(Class<?> clazz) {

    for (Object instance : instances) {
      if (clazz.isInstance(instance)) {
        return instance;
      }
    }

    Constructor<?> constructor = getConstructor(clazz);

    List<Object> constructorArguments = new ArrayList<>();
    for (Class<?> parameterType : constructor.getParameterTypes()) {
      if (isCircular(clazz, parameterType)) {
        throw new RuntimeException(clazz.getName() + ", has circular dependency from parameter: " + parameterType.getName());
      }

      constructorArguments.add(instantiate(parameterType));
    }

    try {
      Object instance = constructor.newInstance(constructorArguments.toArray());

      instances.add(instance);

      return instance;
    } catch (InstantiationException e) {
      // todo proper error handling
      throw new RuntimeException(clazz.getName() + ", is an abstract class", e);
    } catch (IllegalAccessException e) {
      // todo proper error handling
      throw new RuntimeException(clazz.getName() + ", constructor is inaccessible", e);
    } catch (InvocationTargetException e) {
      // todo proper error handling
      throw new RuntimeException(clazz.getName() + ", constructor threw an exception", e);
    }
  }

  private Constructor<?> getConstructor(Class<?> clazz) {
    Constructor<?>[] constructors = clazz.getConstructors();

    if (constructors.length == 0) {
      // todo proper error handling
      throw new RuntimeException(clazz.getName() + ", has no public constructors, or if the class is an array class, or if the class reflects a primitive type or void");
    }
    if (constructors.length > 1) {
      // todo proper error handling
      throw new RuntimeException(clazz.getName() + ", has multiple constructors");
    }

    return constructors[0];
  }

  private boolean isCircular(Class<?> clazz, Class<?> parameter) {

    if (clazz.equals(parameter)) {
      return true;
    }

    for (Class<?> parameterType : getConstructor(parameter).getParameterTypes()) {
      boolean circular = isCircular(clazz, parameterType);

      if (circular) {
        return true;
      }
    }

    return false;
  }
}
