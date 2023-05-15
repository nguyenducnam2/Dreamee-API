package org.dreameeapi.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET = "dreamee-api";
    public static final long EXPIRE_1_HOUR = 1000 * 60 * 60;
    public static final long EXPIRE_10_HOUR = EXPIRE_1_HOUR * 10;
    public static final long EXPIRE_24_HOUR = EXPIRE_1_HOUR * 24;
    public static final long EXPIRE_1_YEAR = EXPIRE_24_HOUR * 365;
    public static final long EXPIRE_10_YEAR = EXPIRE_1_YEAR * 10;

    private boolean isEmptyToken(String token) {
        assert token != null && !token.isEmpty() : new Exception("Empty token");
        return false;
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_1_HOUR))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public String generateToken(String subject, long expire) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }


    public String extractSubject(String token) throws IOException {
        isEmptyToken(token);
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Date extractExpiredDate(String token) {
        isEmptyToken(token);
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    public boolean isExpired(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration().before(new Date());
    }

}
