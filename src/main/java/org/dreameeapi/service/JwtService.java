package org.dreameeapi.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET = "dreamee-api";
    private static final long EXPIRE = 1000 * 60 * 60;

    private boolean isEmptyToken(String token) {
        assert token != null && !token.isEmpty() : new Exception("Empty token");
        return false;
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public String extractSubject(String token) throws Exception {
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
