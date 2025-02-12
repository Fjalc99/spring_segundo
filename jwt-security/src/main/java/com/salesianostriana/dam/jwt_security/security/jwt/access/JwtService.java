package com.salesianostriana.dam.jwt_security.security.jwt.access;

import com.salesianostriana.dam.jwt_security.user.model.User;
import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {


    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_ = "Bearer";


    @Value("${jwt.secret}")
    private String jwtSecret;


    @Value("${jwt.duration}")
    private Long jwtLifeDuration;




    public String generateAccesToken(User user){

        Date tokeExpiration = Date.from(
                LocalDateTime.now()
                        .plusMinutes(jwtLifeDuration)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        return Jwts.builder()
                .header().type(TOKEN_TYPE)
                .and()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(tokeExpiration)

                .compact();

    }

}
