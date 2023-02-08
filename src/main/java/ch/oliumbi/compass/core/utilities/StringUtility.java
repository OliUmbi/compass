package ch.oliumbi.compass.core.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtility {

  public static List<String> splitIntoParts(String input) {
    String[] output = input.split("");

    return Arrays.stream(output).toList();
  }
}
