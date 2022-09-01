package com.example.fitnessnutrition.serviceImpl;
import com.example.fitnessnutrition.service.FoodService;

import com.example.fitnessnutrition.model.Food;
import com.example.fitnessnutrition.repository.FoodRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;


    @Override
    public List<Food> getAllFood() {
        List<Food> foods = new ArrayList<>();
        foodRepository.findAll().forEach(foods::add);
         return foods;
    }

    @Override
    public Food getFoodById(Integer id) {
        //why we use optional
        Optional<Food> food = foodRepository.findById(id) ;
        return food.isPresent() ? food.get() : null ;

    }

    @Override
    public Food insert(Food food) {

        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Integer id, Food f) {
        Food foodFromDb = foodRepository.findById(id).get();
        System.out.println(foodFromDb.toString());
        foodFromDb.setName(f.getName());
        foodFromDb.setCalories(f.getCalories());
        foodRepository.save(foodFromDb);
        return foodFromDb;
    }

    @Override
    public void deleteFood(Integer id) {

        foodRepository.deleteById(id);
    }
}
