package ch.oliumbi.compass.core.logging;

import ch.oliumbi.compass.core.utilities.ValidationUtility;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {

  public static void info(String message) {
    printLog(message, null);
  }

  public static void warn(String message) {
    printLog(message, null);
  }

  public static void warn(String message, Exception exception) {
    printLog(message, exception);
  }

  public static void error(String message) {
    printLog(message, null);
  }

  public static void error(String message, Exception exception) {
    printLog(message, exception);
  }

  private static void printLog(String message, Exception exception) {
    System.out.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] | " + message);

    if (exception == null) return;

    System.out.println(exception);
  }
}
