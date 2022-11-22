package ch.oliumbi.compass.core.toml;

import ch.oliumbi.compass.core.config.Config;
import com.fasterxml.jackson.dataformat.toml.TomlFactory;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;

import java.io.File;
import java.io.IOException;

public class Toml {

    public void parse() throws IOException {
        TomlMapper tomlMapper = new TomlMapper();

        tomlMapper.readerFor()
        Object o = tomlMapper.readerFor(Config.class).without(Feat).readValue(new File("src/main/resources/config-dev.toml"));

        System.out.println(o);

    }
}
