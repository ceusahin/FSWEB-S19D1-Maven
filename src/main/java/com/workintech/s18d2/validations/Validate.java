package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;

public class Validate {
    public static void checkValidId(Long id) {
        if (id <= 0 || id == null) {
            throw new PlantException("Invalid id. (Lower or equal than zero)", HttpStatus.BAD_REQUEST);
        }
    }

    public static void dataControlFruit(Fruit fruit)
    {
        if(fruit == null) {
            throw new PlantException("Fruit can not be null.", HttpStatus.BAD_REQUEST);
        }
    }

    public static void dataControlVegetable(Vegetable vegetable)
    {
        if(vegetable == null) {
            throw new PlantException("Vegetable can not be null.", HttpStatus.BAD_REQUEST);
        }
    }

}
