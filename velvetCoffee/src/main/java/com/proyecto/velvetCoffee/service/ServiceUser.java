package com.proyecto.velvetCoffee.service;

import com.proyecto.velvetCoffee.model.Users;
import com.proyecto.velvetCoffee.repository.RepositoryUser;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ServiceUser {

    // generamos los atributos de la clase
    private final RepositoryUser usuarioRepository;


    // generamos el constructor
    public ServiceUser(RepositoryUser UsuarioRepository) {
        this.usuarioRepository = UsuarioRepository;
    }

    public void save(Users usuario) {
        usuarioRepository.save(usuario);
    }

    public boolean existByUsername(String nombreUsuario) {
        return usuarioRepository.findBynombreUsuario(nombreUsuario).isPresent();
    }

    public Optional<Users> findByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Users create(Users usuario) {
        return usuarioRepository.create(usuario);
    }

    public Users findById(Integer idUsuario) {
        usuarioRepository.findById(idUsuario)
                .orElse(null);

        return null;
    }

    public List<Users> findAll() {
        usuarioRepository.findAll();

        return null;
    }

    public Users update(Users usuario) {
        return usuario;
    }

    public void delete(Integer idUsuario) {
    }
}
