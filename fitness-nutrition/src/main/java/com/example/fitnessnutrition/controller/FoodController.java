package com.example.fitnessnutrition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.fitnessnutrition.model.Food;
import com.example.fitnessnutrition.service.FoodService;


@CrossOrigin("*")    //accepte que les request de seveur 4200 : origin de request
@RestController  // permet d ecrire path variavle
//@ path variable  recuperer la variable dans le path
//@ request body : recuperer le body
@RequestMapping("/api/foods")   //common path

public class FoodController {


    @Autowired   // Dependecies injection : dependence : JPA repo deja injectee avec l installation mais on injecte
    private FoodService foodService;

    @GetMapping("")
    public List<Food> getAllFood(){
        return foodService.getAllFood();
    }

    @PutMapping("/{id}")
    public Food updateFood(@PathVariable int id ,@RequestBody Food f) {
        return foodService.updateFood(id,f);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable int id) {
        foodService.deleteFood(id);
    }

    @PostMapping
    public Food add(@RequestBody Food f) {
        return foodService.insert(f);
    }


    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable int id) {
        return foodService.getFoodById(id);
    }



}


