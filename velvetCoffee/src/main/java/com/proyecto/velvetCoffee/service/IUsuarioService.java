package com.proyecto.velvetCoffee.service;

import com.proyecto.velvetCoffee.model.Users;

import java.util.List;

public interface IUsuarioService {

    Users created(Users usuario);
    Users update(Users usuario);
    Users findById();
    List<Users> findAll();
    void delete(Integer id);
}
