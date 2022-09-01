package com.example.fitnessnutrition.repository;
import com.example.fitnessnutrition.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}