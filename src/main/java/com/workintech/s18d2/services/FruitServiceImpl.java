package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.validations.Validate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository)
    {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit getById(Long id) {
        Validate.checkValidId(id);
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()) {
            return fruitOptional.get();
        }
        throw new PlantException("Id is not exist.", HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public Fruit save(Fruit fruit) {
        Validate.dataControlFruit(fruit);
        return fruitRepository.save(fruit);
    }

    @Override
    @Transactional
    public Fruit delete(Long id) {
        Optional<Fruit> deletedFruit = fruitRepository.findById(id);
        if (deletedFruit.isPresent()) {
            fruitRepository.delete(deletedFruit.get());
            return deletedFruit.get();
        }
        throw new PlantException("Id is not exist.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<Fruit> getAllFruitsByName(String name) {
        return fruitRepository.getAllFruitsByName(name);
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }
}
