package com.example.fitnessnutrition.repository;
import com.example.fitnessnutrition.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Integer> {
}