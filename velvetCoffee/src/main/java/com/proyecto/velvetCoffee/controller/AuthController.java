package com.proyecto.velvetCoffee.controller;

import com.proyecto.velvetCoffee.model.JWTUtils;
import com.proyecto.velvetCoffee.model.Users;
import com.proyecto.velvetCoffee.security.ServicioPersonalizadoAlUsuario;
import com.proyecto.velvetCoffee.service.ServiceUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")

public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final ServiceUser usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private final ServicioPersonalizadoAlUsuario servicioPersonalizadoAlUsuario;


    // constructor
    public AuthController(ServiceUser usuarioService, PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager, JWTUtils jwtUtils,
                          ServicioPersonalizadoAlUsuario servicioPersonalizadoAlUsuario) {

        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.servicioPersonalizadoAlUsuario = servicioPersonalizadoAlUsuario;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getNombreUsuario(),
                    authRequest.getContraseña())
                    );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nombre de usuario o contraseña incorrecta");
        }

        UserDetails userDetails = servicioPersonalizadoAlUsuario.loadUserByUsername(authRequest.getNombreUsuario());
            String jwt = jwtUtils.generateToken(userDetails);
                return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users usuario) {
        if (usuarioService.existByUsername(usuario.getNombreUsuario())) {
            return ResponseEntity.status(409).body("Usuario ingresado ya existe. Por favor, indique un nuevo usuario");

        }

        String encodePassword = passwordEncoder.encode(usuario.getContraseña());
            usuario.setContraseña(encodePassword);
            usuarioService.save(usuario);
                return ResponseEntity.ok("Usuario registrado correctamente");

    }

}





