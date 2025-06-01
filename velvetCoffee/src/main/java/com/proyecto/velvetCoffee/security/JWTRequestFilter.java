package com.proyecto.velvetCoffee.security;

import com.proyecto.velvetCoffee.model.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


/**
 * --PAUTAS--
 * 1º) leemos el header "Authorization" de la petición
 * 2º) si contiene un token JWT, lo extraemos y obtenemos el nombre de usuario
 * 3º) verificamos que no haya una autenticación previa
 * 4º) cargamos el usuario desde la base de datos con 'loadUserByUsername'
 * 5º) Validamos el token con 'jwtUtil.validateToken(...)'
 * 6º) Si todo es válido, configurar el contexto de seguridad con:
 * 'UsernamePasswordAuthenticationToken'
 */


// 1º)
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private ServicioPersonalizadoAlUsuario personalizacionUsuarioService;
    @Autowired
    private JWTUtils jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {


        // 1º)
        final String authHeader = request.getHeader("Authorization");


        String username = null;
        String jwt = null;


        // 2º)
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }


        // 3º)
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // 4º)
            UserDetails userDetails = this.personalizacionUsuarioService.loadUserByUsername(username);

            // 5º)
            if (jwtUtil.validateToken(jwt, userDetails)) {

                // 6º)
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        chain.doFilter(request, response);
    }

}