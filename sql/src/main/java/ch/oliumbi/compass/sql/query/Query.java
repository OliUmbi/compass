package ch.oliumbi.compass.sql.query;

import java.util.List;

public record Query(
    String executable,
    List<String> inputs,
    List<String> outputs
) {

}
