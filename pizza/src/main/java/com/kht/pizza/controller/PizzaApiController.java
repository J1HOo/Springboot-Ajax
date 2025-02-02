package com.kht.pizza.controller;

import com.kht.pizza.model.entity.Pizza;
import com.kht.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/pizzas")
public class PizzaApiController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable("id") int id) {
        return pizzaService.getPizzaById(id);
    }

    @PostMapping
    public Pizza createPizza(
        @RequestParam("name") String name,
        @RequestParam("price") int price,
        @RequestParam(value = "description", required = false) String description,
        @RequestParam(value = "image", required = false) MultipartFile image
    ) throws IOException {
        String imagePath = "";
        // 이미지 파일이 첨부되었으면 서버의 uploads 디렉토리에 저장
        if (image != null && !image.isEmpty()) {
            String uploadDir = "/Users/parkjiho/Workspace/pizza-image-path/";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }
            // 파일명에 현재 시간을 붙여 유니크하게 처리
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            File dest = new File(uploadDir + fileName);
            image.transferTo(dest);
            imagePath = "/pizza-image/" + fileName;
        }

        Pizza pizza = new Pizza();
        pizza.setName(name);
        pizza.setPrice(price);
        pizza.setDescription(description);
        pizza.setImagePath(imagePath);
        return pizzaService.createPizza(pizza);
    }

    // 메뉴 수정 (이미지 재업로드 가능)
    @PutMapping("/{id}")
    public Pizza updatePizza(
        @PathVariable int id,
        @RequestParam("name") String name,
        @RequestParam("price") int price,
        @RequestParam(value = "description", required = false) String description,
        @RequestParam(value = "image", required = false) MultipartFile image
    ) throws IOException {
        Pizza existingPizza = pizzaService.getPizzaById(id);
        if (existingPizza == null) {
            return null;
        }

        String imagePath = existingPizza.getImagePath();
        // 새 이미지 파일이 첨부된 경우 업로드 후 경로 갱신
        if (image != null && !image.isEmpty()) {
            String uploadDir = "/Users/parkjiho/Workspace/pizza-image-path/";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            File dest = new File(uploadDir + fileName);
            image.transferTo(dest);
            imagePath = "/pizza-image/" + fileName;
        }

        existingPizza.setName(name);
        existingPizza.setPrice(price);
        existingPizza.setDescription(description);
        existingPizza.setImagePath(imagePath);

        return pizzaService.updatePizza(id, existingPizza);
    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable int id) {
        pizzaService.deletePizza(id);
    }
}