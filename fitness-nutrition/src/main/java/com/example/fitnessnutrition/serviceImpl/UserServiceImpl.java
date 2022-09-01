package com.example.fitnessnutrition.serviceImpl;
import java.util.Optional;

import com.example.fitnessnutrition.model.User;
import com.example.fitnessnutrition.repository.UserRepository;
import com.example.fitnessnutrition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;


    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id) ;
        return user.isPresent() ? user.get() : null ;
    }
    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User u) {
        User userFromDb = userRepository.findById(id).get();
        System.out.println(userFromDb.toString());
        userFromDb.setFirstName(u.getFirstName());
        userFromDb.setLastName(u.getLastName());
        userFromDb.setEmail(u.getEmail());
        userFromDb.setInitialbodyFat(u.getInitialbodyFat());
        userFromDb.setAge(u.getAge());
        userFromDb.setGender(u.getGender());
        userFromDb.setHeight(u.getHeight());
        userFromDb.setTargetbodyFat(u.getTargetbodyFat());
        userFromDb.setInitialWeight(u.getInitialWeight());
        userFromDb.setTargetWeight(u.getTargetWeight());
        userFromDb.setCalories(u.getCalories());
        userFromDb.setTargetCalories(u.getTargetCalories());
        userFromDb.setGoal(u.getGoal());

        userFromDb.setImageUrl(u.getImageUrl());
        userRepository.save(userFromDb);
        return userFromDb;
    }

    @Override
    public void deleteUser(Integer id) {

        userRepository.deleteById(id);
    }
}
