package ch.oliumbi.compass.core.configuration.data;

public record DatabaseConfigurationRecord(
    String url,
    String username,
    String password
) {

}
