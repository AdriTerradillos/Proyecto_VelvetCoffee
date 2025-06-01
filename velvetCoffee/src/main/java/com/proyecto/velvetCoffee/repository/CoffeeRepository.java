package com.proyecto.velvetCoffee.repository;

import com.proyecto.velvetCoffee.model.Coffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Page<Coffee> findAll(Pageable pageable);
} 