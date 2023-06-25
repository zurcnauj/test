package com.test.testSpringboot.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${jwt.key}")
    private static final String jwt_key = "secreto"; // Clave secreta para firmar y validar el token
    @Value("${jwt.time.millis:1000}")
    private static final long jwt_time_millis = 86400000; // Tiempo de expiración del token (24 horas)

    public String generateToken() {
        Date expirationDate = new Date(System.currentTimeMillis() + jwt_time_millis);
        return Jwts.builder()
        .setExpiration(expirationDate)
        .signWith(SignatureAlgorithm.HS512, jwt_key)
        .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwt_key).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
        .setSigningKey(jwt_key)
        .parseClaimsJws(token)
        .getBody();

        return claims.getSubject();
    }
}

