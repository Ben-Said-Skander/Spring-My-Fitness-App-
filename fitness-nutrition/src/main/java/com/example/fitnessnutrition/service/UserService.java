package com.example.fitnessnutrition.service;
import com.example.fitnessnutrition.model.User;
import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUserById(Integer id);
    User updateUser(Integer id, User u);
    User insert(User u);
    void deleteUser(Integer id);
}