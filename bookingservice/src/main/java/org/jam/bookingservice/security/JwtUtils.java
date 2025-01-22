package org.jam.bookingservice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Configuration
public class JwtUtils {

    private static final String KEY = "key";  // Normally this would be stored securely, but this is more for learning

    /**
     * Method for generating a token
     *
     * @return the string token, signed by Jwt
     */
    public static String generateToken() {
        // This generates a random token value
        String tokenValue = UUID.randomUUID().toString();
        log.debug("Generated {} token value.", tokenValue);

        SecretKey key = new SecretKeySpec(KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // token will expire in 1 hour
            .claim("token", tokenValue)
            .signWith(key)
            .compact();
    }

    /**
     * Validate a token sent in with a request
     *
     * @param token the token to validate
     * @return whether to grant access or not as a boolean
     */
    public static boolean validateToken(String token) {
        try {
            SecretKey key = new SecretKeySpec(KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to check if a token is expired.
     *
     * @param token the token to check for expiration
     * @return whether the token is expired as a true or false value
     */
    public static boolean isTokenExpired(String token) {
        SecretKey key = new SecretKeySpec(KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Date expiration = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getExpiration();
        return expiration.before(new Date());
    }
}
