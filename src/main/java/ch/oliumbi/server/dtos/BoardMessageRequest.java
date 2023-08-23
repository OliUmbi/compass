package ch.oliumbi.server.dtos;

public record BoardMessageRequest(
    String title,
    String description,
    String name
) {

}
