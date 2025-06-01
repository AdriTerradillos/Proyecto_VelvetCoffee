package com.proyecto.velvetCoffee.service;

import com.proyecto.velvetCoffee.model.Coffee;

import java.util.List;

public interface ICafeService {

    Coffee created(Coffee coffee);
    Coffee update(Coffee coffee);
    Coffee findById(Integer id);
    List<Coffee> findAll();
    void delete(Integer id);
}
