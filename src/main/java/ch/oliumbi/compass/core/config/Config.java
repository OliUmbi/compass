package ch.oliumbi.compass.core.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {

    private Server server;

    @Getter
    @Setter
    public static class Server {
        private int port;
        private String host;
    }
}
