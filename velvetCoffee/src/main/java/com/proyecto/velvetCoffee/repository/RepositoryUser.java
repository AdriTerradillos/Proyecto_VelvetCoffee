package com.proyecto.velvetCoffee.repository;

import com.proyecto.velvetCoffee.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepositoryUser extends CrudRepository <Users, Integer> {

    public Optional<Users> findByNombreUsuario(String nombreUsuario);


    Optional<Object> findBynombreUsuario(String nombreUsuario);

    Users create(Users usuario);
}
