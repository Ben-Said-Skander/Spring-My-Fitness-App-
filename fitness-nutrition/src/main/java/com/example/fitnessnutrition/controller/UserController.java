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

import com.example.fitnessnutrition.model.User;
import com.example.fitnessnutrition.service.UserService;


@CrossOrigin("*")    //accepte que les request de seveur 4200 : origin de request
@RestController  // permet d ecrire path variavle
//@ path variable  recuperer la variable dans le path
//@ request body : recuperer le body
@RequestMapping("/api/users")   //common path

public class UserController {


    @Autowired   // Dependecies injection : dependence : JPA repo deja injectee avec l installation mais on injecte
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PutMapping("/{id}")
    public User updateFood(@PathVariable int id ,@RequestBody User u) {
        return userService.updateUser(id,u);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping
    public User add(@RequestBody User u) {
        return userService.insert(u);
    }


    @GetMapping("/{id}")
    public User User(@PathVariable int id) {
        return userService.getUserById(id);
    }



}


