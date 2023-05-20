package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "nutrition")
public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calories_to_intake")
    private Double caloriesToIntake;

    @Column(name = "protein_intake")
    private Double proteinIntake;

    @Column(name = "carbohydrates_intake")
    private Double carbohydratesIntake;

    @Column(name = "fats_intake")
    private Double fatsIntake;

    public Fitness getFitness() {
        return fitness;
    }

    public void setFitness(Fitness fitness) {
        this.fitness = fitness;
    }
    @JsonIgnore
    @JsonBackReference
    @OneToOne
    @JoinColumn(name="fitness_id")
    private Fitness fitness;



    public Nutrition(double caloriesToIntake, double proteinIntake, double carbohydratesIntake, double fatsIntake) {
        this.caloriesToIntake = caloriesToIntake;
        this.proteinIntake = proteinIntake;
        this.carbohydratesIntake = carbohydratesIntake;
        this.fatsIntake = fatsIntake;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCaloriesToIntake() {
        return caloriesToIntake;
    }

    public void setCaloriesToIntake(Double caloriesToIntake) {
        this.caloriesToIntake = caloriesToIntake;
    }

    public Double getProteinIntake() {
        return proteinIntake;
    }

    public void setProteinIntake(Double proteinIntake) {
        this.proteinIntake = proteinIntake;
    }

    public Double getCarbohydratesIntake() {
        return carbohydratesIntake;
    }

    public void setCarbohydratesIntake(Double carbohydratesIntake) {
        this.carbohydratesIntake = carbohydratesIntake;
    }

    public Double getFatsIntake() {
        return fatsIntake;
    }

    public void setFatsIntake(Double fatsIntake) {
        this.fatsIntake = fatsIntake;
    }



    public Nutrition() {
    }

}
