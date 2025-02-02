package com.kht.pizza.service;

import com.kht.pizza.model.entity.Pizza;
import com.kht.pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas(){
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(int id){
        return pizzaRepository.findById(id).orElse(null);
    }

    public Pizza createPizza(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(int id, Pizza pizza) {
        Pizza existingPizza = pizzaRepository.findById(id).orElse(null);
        if(existingPizza != null) {
            existingPizza.setName(pizza.getName());
            existingPizza.setPrice(pizza.getPrice());
            existingPizza.setDescription(pizza.getDescription());
            existingPizza.setImagePath(pizza.getImagePath());
            return pizzaRepository.save(existingPizza);
        }
        return null;
    }

    public void deletePizza(int id) {
        pizzaRepository.deleteById(id);
    }
}