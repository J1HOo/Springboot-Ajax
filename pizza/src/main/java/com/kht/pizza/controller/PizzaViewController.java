package com.kht.pizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaViewController {

    @GetMapping("/pizzas")
    public String showPizzaList() {
        return "pizzas";
    }

    @GetMapping("/pizzas/add")
    public String showAddPizzaForm() {
        return "add-pizza";
    }

    @GetMapping("/pizzas/detail")
    public String showPizzaDetail(@RequestParam("id") int id) {
        return "pizza-detail";
    }

    @GetMapping("/pizzas/edit")
    public String showEditPizzaForm(@RequestParam("id") int id) {
        return "edit-pizza";
    }
}