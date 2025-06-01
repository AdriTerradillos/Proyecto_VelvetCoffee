package com.proyecto.velvetCoffee.controller;


import com.proyecto.velvetCoffee.res.PageResponseCoffee;
import com.proyecto.velvetCoffee.model.Coffee;
import com.proyecto.velvetCoffee.service.ServiceCoffee;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/coffeeShop")

public class CoffeeShopController {

// puedo utilizar inyección de depedencias @Autowired ó plantear un nuevo contructor a partir de los atributo(s)
    // o un contructor, lo cual es más recomendable y ofrece mayor claridad


    private final ServiceCoffee serviceCoffee;

    public CoffeeShopController(ServiceCoffee serviceCoffee) {
        this.serviceCoffee = serviceCoffee;
    }


    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PageResponseCoffee> getCafes (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int pagSize) {

        Page<Coffee> cafePage = ServiceCoffee.getAll(page, pagSize);
        PageResponseCoffee cafePageResponse = new PageResponseCoffee(
                .cafePage.getContent(),
                (int) cafePage.getTotalElements(),
                cafePage.getTotalPages(),
                cafePage.getNumber()
        );

        return ResponseEntity.status(HttpStatus.OK).body(cafePageResponse);

    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee) {
        try {
            Coffee savedCoffee = ServiceCoffee.save(coffee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCoffee);


        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Coffee> deleteCoffee(@PathVariable Long id) {

        try {
            Coffee deletedCoffee = ServiceCoffee.deleteCafe(id);
                return ResponseEntity.status(HttpStatus.OK).body(deletedCoffee);

        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }


    }


