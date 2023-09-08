package ch.oliumbi.compass.crypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * + fast
 * - not as memory hard
 * - not as brute force hard
 */
public class BCrypt implements Hash {

  private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  @Override
  public String generate(String input) {
    return bCryptPasswordEncoder.encode(input);
  }

  @Override
  public boolean matches(String input, String hash) {
    return bCryptPasswordEncoder.matches(input, hash);
  }
}
