package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{
    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository)
    {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable getById(Long id) {
        // VALIDATE
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()) {
            return vegetableOptional.get();
        }
        // new throw exception
        return null;
    }

    @Override
    @Transactional
    public Vegetable save(Vegetable vegetable) {
        // VALIDATE
        return vegetableRepository.save(vegetable);
    }

    @Override
    @Transactional
    public Vegetable delete(Long id) {
        Optional<Vegetable> deletedVegetable = vegetableRepository.findById(id);
        if (deletedVegetable.isPresent()) {
            vegetableRepository.delete(deletedVegetable.get());
            return deletedVegetable.get();
        }
        // new throw exception
        return null;
    }

    @Override
    public List<Vegetable> getAllFruitsByName(String name) {
        return vegetableRepository.getAllVegetablesByName(name);
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }
}
