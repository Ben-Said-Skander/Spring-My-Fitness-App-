package com.example.fitnessnutrition.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")

public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl = "https://icon-library.com/images/default-user-icon/default-user-icon-13.jpg";
    private int age ;
    private double height ;
    private int gender ;
    private double  initialbodyFat ;
    private double  targetbodyFat ;
    private double calories ;
    private double targetCalories ;
    private double initialWeight ;
    private double targetWeight ;
    private String goal ;


}