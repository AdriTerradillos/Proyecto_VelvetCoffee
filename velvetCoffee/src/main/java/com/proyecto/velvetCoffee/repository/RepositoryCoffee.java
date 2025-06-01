package com.proyecto.velvetCoffee.repository;

import com.proyecto.velvetCoffee.model.Coffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface RepositoryCoffee {

    Optional<Coffee> save(Coffee cafe);
    void deleteById(Long id);
    Optional<Coffee> findById(Long id);
    Iterable<Coffee> findAll();
    Page<Coffee> findAll(Pageable pageable );
}
