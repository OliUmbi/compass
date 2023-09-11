package ch.oliumbi.compass.sql.query;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryService {

  public Query parse(String original) {
    return new Query(
        executable(original),
        inputs(original),
        outputs(original)
    );
  }

  private String executable(String original) {
    return original
        .replaceAll(":\\w*", "?")
        .replaceAll("(?<!INSERT.)(INTO)[\\S\\s]*", "");
  }

  private List<String> inputs(String original) {
    List<String> inputs = new ArrayList<>();

    Matcher matcher = Pattern.compile("(?<=:)(\\w*)").matcher(original);

    while (matcher.find()) {
      inputs.add(matcher.group(1));
    }

    return inputs;
  }

  private List<String> outputs(String original) {
    List<String> outputs = new ArrayList<>();

    Matcher matcher = Pattern.compile("(?<=(?<!INSERT.)(INTO)[\\S\\s]*)(?<=INTO[\\S\\s]*)(\\w*)").matcher(original);

    while (matcher.find()) {
      if (matcher.group(2).isEmpty()) {
        continue;
      }

      outputs.add(matcher.group(2));
    }

    return outputs;
  }
}
