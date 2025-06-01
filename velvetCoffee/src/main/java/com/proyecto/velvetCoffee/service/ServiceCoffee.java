package com.proyecto.velvetCoffee.service;

import com.proyecto.velvetCoffee.model.Coffee;
import com.proyecto.velvetCoffee.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ServiceCoffee {
    
    private static CoffeeRepository coffeeRepository;

    @Autowired
    public ServiceCoffee(CoffeeRepository coffeeRepository) {
        ServiceCoffee.coffeeRepository = coffeeRepository;
    }

    public static Page<Coffee> getAll(int page, int pageSize) {
        return coffeeRepository.findAll(PageRequest.of(page, pageSize));
    }

    public static Coffee save(Coffee coffee) {
        if (coffee.getName() == null || coffee.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Coffee name cannot be empty");
        }
        if (coffee.getPrice() == null || coffee.getPrice() <= 0) {
            throw new IllegalArgumentException("Coffee price must be greater than 0");
        }
        return coffeeRepository.save(coffee);
    }

    public static Coffee deleteCafe(Long id) {
        Coffee coffee = coffeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Coffee not found with id: " + id));
        coffeeRepository.deleteById(id);
        return coffee;
    }
}




