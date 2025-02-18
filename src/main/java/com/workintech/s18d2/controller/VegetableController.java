package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/vegetables")
    public List<Vegetable> getAllVegetablesByPriceAsc(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/vegetables/desc")
    public List<Vegetable> getAllVegetablesByPriceDesc(){
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/vegetables/{id}")
    public Vegetable findById(@PathVariable long id) {
        return vegetableService.getById(id);
    }

    @PostMapping("/vegetables")
    public Vegetable saveOrUpdate(Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/vegetables/{name}")
    public List<Vegetable> searchByName(@PathVariable String name) {
        return vegetableService.getAllFruitsByName(name);
    }

    @DeleteMapping("/vegetables/{id}")
    public Vegetable delete(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
}
