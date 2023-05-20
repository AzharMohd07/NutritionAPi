package com.example.demo.service;

import com.example.demo.entity.Fitness;

import java.util.List;

public interface FitnessService {

    Fitness updateFitness(Long fitnessId, Fitness report);

    Fitness createFitness(Fitness fitness);

    Fitness getLatestFitness();


    List<Fitness> getAllFitness();

    void deleteFitness(Long fitnessId);

    Fitness getFitnessById(Long fitnessId);
}
