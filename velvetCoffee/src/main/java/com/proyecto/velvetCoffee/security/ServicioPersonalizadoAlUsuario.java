package com.proyecto.velvetCoffee.security;

import com.proyecto.velvetCoffee.model.Users;
import com.proyecto.velvetCoffee.service.ServiceUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


// inyectamos anotación @Service (capa de lógica del negocio)
@Service
public class ServicioPersonalizadoAlUsuario implements UserDetailsService  {

    // generamos atributos de la clase
    private final ServiceUser usuarioService;


    // constructor
    public ServicioPersonalizadoAlUsuario(ServiceUser usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <Users> usuario = usuarioService.findByNombreUsuario(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre de usuario: " + username);

        }

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.get().getNombreUsuario())
                .password(usuario.get().getContraseña())
                .roles(usuario.get().getRol())
                .build();
    }
}
