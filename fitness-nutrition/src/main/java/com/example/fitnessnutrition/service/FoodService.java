package com.example.fitnessnutrition.service;
import com.example.fitnessnutrition.model.Food;
import java.util.List;

public interface FoodService {

    List<Food> getAllFood();

    Food getFoodById(Integer id);

    Food insert(Food f);

    Food updateFood(Integer id , Food f);

    void deleteFood(Integer id);
}