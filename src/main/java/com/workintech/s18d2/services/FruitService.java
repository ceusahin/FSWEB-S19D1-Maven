package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    Fruit getById(Long id);
    Fruit save(Fruit fruit);
    Fruit delete(Long id);
//    Fruit update(Fruit fruit);
    List<Fruit> getAllFruitsByName(String name);
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName(String name);
    List<Fruit> getByPriceDesc();
}