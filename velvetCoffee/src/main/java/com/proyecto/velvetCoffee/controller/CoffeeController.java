package com.proyecto.velvetCoffee.controller;


import com.proyecto.velvetCoffee.model.Coffee;
import com.proyecto.velvetCoffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/coffeeShop")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping
    public ResponseEntity <List<Coffee>> findAll() {
        return new ResponseEntity<>(coffeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coffee> createdCoffee(@RequestBody Coffee coffee) {
        Coffee created = coffeeService.created(coffee);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping
    public Coffee update(Coffee coffee) {
        return coffeeService.update(coffee);
    }

    @GetMapping("/{id}")
    public Coffee findById(@PathVariable("id") Integer idCoffee) {
        return  coffeeService.findById(idCoffee);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable("id") Integer idCoffee) {
        coffeeService.delete(idCoffee);
    }







}
