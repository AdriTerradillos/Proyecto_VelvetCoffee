package com.proyecto.velvetCoffee.controller;

import com.proyecto.velvetCoffee.model.Users;
import com.proyecto.velvetCoffee.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// inyectamos las dependencias necesarias
@RestController
@RequestMapping("/clientes")

public class CoffeeShopUsersController {


    // atributo (dentro de @Autowired)

    @Autowired
    private ServiceUser usuarioService;


    // generamos ahora los endpoint de la clase ClientController

    @GetMapping
    public List<Users> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping
    public Users create(@RequestBody Users usuario) {
        return usuarioService.create(usuario);
    }

    @PutMapping
    public Users update(@RequestBody Users usuario) {
        return usuarioService.update(usuario);
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable("id") Integer idUsuario) {
        return usuarioService.findById(idUsuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idUsuario) {
        usuarioService.delete(idUsuario);
    }

}
