package com.proyecto.velvetCoffee.service;


import com.proyecto.velvetCoffee.model.Coffee;
import com.proyecto.velvetCoffee.repository.ICoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService implements ICoffeeService {

    @Autowired  // ESTE BEAN ESTARÁ SIEMPRE DISPONIBLE EN NUESTRO SERVICES O NEGOCIO
    private ICoffeeRepository coffeeRepo;

    @Override
    public Coffee created(Coffee coffee) { // ← renombrar de "created" a "create"
        return coffeeRepo.save(coffee);
    }

    @Override
    public Coffee update(Coffee coffee) {
        return coffeeRepo.save(coffee);
    }

    @Override
    public Coffee findById(Integer id) {
       Optional <Coffee> coffeeOptional;
        coffeeOptional = coffeeRepo.findById(id);
        return coffeeOptional.orElse(null);
    }

    @Override
    public List<Coffee> findAll() {
        return (List<Coffee>) coffeeRepo.findAll();
    }

    @Override
    public void delete(Integer id) {
        coffeeRepo.deleteById(id);
    }
}
