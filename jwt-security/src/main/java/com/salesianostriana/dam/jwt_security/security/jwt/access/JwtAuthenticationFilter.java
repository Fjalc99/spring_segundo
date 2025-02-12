package com.salesianostriana.dam.jwt_security.security.jwt.access;


import ch.qos.logback.core.util.StringUtil;
import com.salesianostriana.dam.jwt_security.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getJwtAccessTokenFromRequest(request);

        //Validar el token si es valido autenticar el usuario


        if(StringUtils.hasText(token) && jwtService.validateAccesToken(token))


            //Obtener el sub del token, que es el id del usuario
            //Buscar al usuario por id
            //colocar el usuario autenticado en el contexto de seguridad




        filterChain.doFilter(request, response);

    }

    private String getJwtAccessTokenFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(JwtService.TOKEN_HEADER);
        //Bearer adadadadadadadadadd.dadadadad.adadadada
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtService.TOKEN_)){
            return bearerToken.substring()
        }
    }

}
