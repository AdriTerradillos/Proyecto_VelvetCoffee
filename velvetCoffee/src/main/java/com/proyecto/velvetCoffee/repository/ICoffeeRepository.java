package com.proyecto.velvetCoffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoffeeRepository extends JpaRepository<Coffee, Integer> {
}
