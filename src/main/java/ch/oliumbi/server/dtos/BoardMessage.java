package ch.oliumbi.server.dtos;

import java.util.List;

public record BoardMessage(
    Person person,
    String title,
    String description,
    List<BoardAnswer> answers
) {

}
