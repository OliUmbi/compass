package ch.oliumbi.compass.core.utilities;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.core.exceptions.ReflectionException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionUtility {

  public static Method getSuperMethod(Class<?> clazz, String name, Class<?>... types) {
    try {
      if (types.length == 0) {
        return clazz.getDeclaredMethod(name);
      }

      return clazz.getDeclaredMethod(name, types);
    } catch (NoSuchMethodException e) {
      if (clazz.getSuperclass() == null) {
        throw new ReflectionException("failed to find method " + name, e);
      }

      return getSuperMethod(clazz.getSuperclass(), name, types);
    }
  }

  public static Field getSuperField(Class<?> clazz, String name) {
    try {
      return clazz.getDeclaredField(name);
    } catch (NoSuchFieldException e) {
      if (clazz.getSuperclass() == null) {
        throw new ReflectionException("failed to find field " + name, e);
      }

      return getSuperField(clazz.getSuperclass(), name);
    }
  }

  public static List<Field> getSuperFields(Class<?> clazz) {
    List<Field> fields = new ArrayList<>(List.of(clazz.getDeclaredFields()));

    if (clazz.getSuperclass() == null) {
      return fields;
    }

    fields.addAll(getSuperFields(clazz.getSuperclass()));

    return fields;
  }

  public static Object invokeMethod(Method method, Object target, Object... args) {
    try {
      return method.invoke(target, args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new ReflectionException("failed to invoke function " + method.getName(), e);
    }
  }

  public static <T> T createInstance(Class<T> clazz) {
    Constructor<T> constructor;

    try {
      constructor = clazz.getConstructor();
    } catch (NoSuchMethodException e) {
      throw new ReflectionException("failed to find constructor for " + clazz.getName(), e);
    }

    try {
      return constructor.newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new ReflectionException("failed to instantiate class " + clazz.getName(), e);
    }
  }
}
