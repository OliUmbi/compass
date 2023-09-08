package ch.oliumbi.compass.crypt;

public interface Hash {

  String generate(String input);

  boolean matches(String input, String hash);
}
