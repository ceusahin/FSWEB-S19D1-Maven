package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/fruit")
    public List<Fruit> getAllFruitsByPriceAsc(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/fruit/desc")
    public List<Fruit> getAllFruitsByPriceDesc(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/fruit/{id}")
    public Fruit findById(@PathVariable long id) {
        return fruitService.getById(id);
    }

    @PostMapping("/fruit")
    public Fruit saveOrUpdate(Fruit fruit){
        return fruitService.save(fruit);
    }

    @GetMapping("/fruit/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/fruit/{id}")
    public Fruit delete(@PathVariable Long id) {
        return fruitService.delete(id);
    }

}
