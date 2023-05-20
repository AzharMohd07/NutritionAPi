package com.example.demo.controllers;

import com.example.demo.entity.Fitness;
import com.example.demo.entity.Nutrition;
import com.example.demo.repository.FitnessRepository;
import com.example.demo.repository.NutritionRepository;
import com.example.demo.service.FitnessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class NutritionController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private FitnessServiceImpl fitnessService;

    @Autowired
    private FitnessRepository fitnessRepository;

    @Autowired
    private NutritionRepository nutritionRepository;


    public static void main(String[] args) {

        SpringApplication.run(NutritionController.class, args);
    }
    @GetMapping("/nutritionCalculation")
    public Nutrition calculateNutritionData() {
        Fitness fitness = restTemplate.getForObject("http://localhost:8181/latest", Fitness.class);
        System.out.print(fitness);
        System.out.print("fitness test");

        Nutrition nutrition = new Nutrition();
        assert fitness != null;
        nutrition.setCaloriesToIntake(fitness.getCaloriesBurned() * 1.2);
        nutrition.setProteinIntake(fitness.getTotalKmWalked() * 2);
        nutrition.setCarbohydratesIntake(fitness.getPulseRate() * 1.4);
        nutrition.setFatsIntake(fitness.getPulseRate() * 1.1);

        nutrition.setFitness(fitness);
        return nutritionRepository.save(nutrition);

    }
    @GetMapping("/fit/access/{id}")
    public String accessAllFitnessApi(@PathVariable("id") Long fitnessId) {

        Fitness fitness = fitnessService.getFitnessById(fitnessId);
        if (fitnessId != null) {

            return fitness.getTotalKmWalked().toString();

        } else if (fitness.getTotalKmWalked() > 5) {
            return fitnessService.createFitness(fitness).toString();

        } else if (fitness.getCaloriesBurned() < 500.0) {
            return fitnessService.updateFitness(fitnessId, fitness).toString();


        }
        return "Enter a valid credential";
    }
    
}