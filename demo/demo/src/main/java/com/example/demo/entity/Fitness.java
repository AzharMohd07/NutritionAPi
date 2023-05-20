package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "fitness")
public class Fitness {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Double getTotalKmWalked() {
        return totalKmWalked;
    }

    public void setTotalKmWalked(Double totalKmWalked) {
        this.totalKmWalked = totalKmWalked;
    }

    public Integer getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

    public Fitness(Long id, Double caloriesBurned, Double totalKmWalked, Integer pulseRate) {
        this.id = id;
        this.caloriesBurned = caloriesBurned;
        this.totalKmWalked = totalKmWalked;
        this.pulseRate = pulseRate;
    }

    public Fitness() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calories_burned")
    private Double caloriesBurned;

    @Column(name = "total_km_walked")
    private Double totalKmWalked;

    @Column(name = "pulse_rate")
    private Integer pulseRate;

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }
    @JsonIgnore
    @JsonBackReference
    @OneToOne(mappedBy="fitness",cascade = CascadeType.ALL)
    private Nutrition nutrition;

}
