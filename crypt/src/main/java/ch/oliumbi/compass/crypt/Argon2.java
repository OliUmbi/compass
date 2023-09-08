package ch.oliumbi.compass.crypt;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

/**
 * + memory hardness
 * - time intensive
 */
public class Argon2 implements Hash {

  private final Argon2PasswordEncoder argon2PasswordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

  @Override
  public String generate(String input) {
    return argon2PasswordEncoder.encode(input);
  }

  @Override
  public boolean matches(String input, String hash) {
    return argon2PasswordEncoder.matches(input, hash);
  }
}
