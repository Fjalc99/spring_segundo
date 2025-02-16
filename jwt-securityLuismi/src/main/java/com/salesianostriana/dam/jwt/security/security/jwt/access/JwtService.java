package com.salesianostriana.dam.jwt.security.security.jwt.access;


import com.salesianostriana.dam.jwt.security.security.exceptionhandling.JwtException;
import com.salesianostriana.dam.jwt.security.user.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {

    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.duration}")
    private long jwtLifeInMinutes;

    private JwtParser jwtParser;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {

        secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        jwtParser = Jwts.parser()
                .verifyWith(secretKey)
                .build();

    }

    public String generateAccessToken(User user) {

        Date tokeExpirationDate =
                Date.from(
                        LocalDateTime
                                .now()
                                .plusMinutes(jwtLifeInMinutes)
                                .atZone(ZoneId.systemDefault())
                                .toInstant()
                );

        return Jwts.builder()
                .header().type(TOKEN_TYPE)
                .and()
                .subject(user.getId().toString())
                .claim("activation", true)
                .issuedAt(new Date())
                .expiration(tokeExpirationDate)
                .signWith(secretKey)
                .compact();


    }


    public String generateActivationToken(User user) {
        Date tokenExpirationDate = Date.from(
                LocalDateTime.now()
                        .plusDays(1)  // Expira en 1 día
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        return Jwts.builder()
                .header().type(TOKEN_TYPE)
                .and()
                .subject(user.getId().toString())
                .claim("activation", true)  // 🔥 Solo el token de activación tiene esto
                .issuedAt(new Date())
                .expiration(tokenExpirationDate)
                .signWith(secretKey)
                .compact();
    }


    public UUID getUserIdFromAccessToken(String token) {
        String sub = jwtParser.parseClaimsJws(token).getBody().getSubject();
        return UUID.fromString(sub);
    }

    public boolean validateAccessToken(String token) {
        try {
            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            // Si el token tiene "activation", NO es un token de acceso válido
            if (claims.containsKey("activation")) {
                throw new JwtException("Este token no es un token de acceso válido.");
            }
            return true;
        } catch (Exception ex) {
            throw new JwtException(ex.getMessage());
        }
    }

    public boolean isActivationToken(String token) {
        try {
            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            return claims.containsKey("activation") && claims.get("activation", Boolean.class);
        } catch (Exception ex) {
            return false; // Si hay error, no es un token de activación válido
        }


    }
}
