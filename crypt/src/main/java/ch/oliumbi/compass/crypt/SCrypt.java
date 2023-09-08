package ch.oliumbi.compass.crypt;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * + brute force hardness
 * - not as memory hard
 */
public class SCrypt implements Hash {

  private final SCryptPasswordEncoder sCryptPasswordEncoder = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();

  @Override
  public String generate(String input) {
    return sCryptPasswordEncoder.encode(input);
  }

  @Override
  public boolean matches(String input, String hash) {
    return sCryptPasswordEncoder.matches(input, hash);
  }
}
