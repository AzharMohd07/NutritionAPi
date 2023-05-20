package com.example.demo.controllers;

import com.example.demo.entity.Fitness;
import com.example.demo.service.FitnessService;
import com.example.demo.service.FitnessValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FitnessController {
    private final FitnessService fitnessService;
    private final FitnessValidator fitnessValidator;

    @Autowired
    public FitnessController(FitnessService fitnessService, FitnessValidator fitnessValidator) {
        this.fitnessService = fitnessService;
        this.fitnessValidator = fitnessValidator;
    }
    @PostMapping("/fitness")
    public ResponseEntity<?> createFitness(@RequestBody Fitness fitness, BindingResult bindingResult) {
        fitnessValidator.validate(fitness, bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        Fitness createdFitness = fitnessService.createFitness(fitness);
        return ResponseEntity.ok(createdFitness);
    }
    @GetMapping("/latest")
    public ResponseEntity<Fitness> getLatestFitness() {
        Fitness latestFitness = fitnessService.getLatestFitness();
        return ResponseEntity.ok(latestFitness);
    }
    @GetMapping("/fit")
    public ResponseEntity<List<Fitness>> getAllFitness() {
        List<Fitness> latestFitness = fitnessService.getAllFitness();
        return ResponseEntity.ok(latestFitness);
    }

    @GetMapping("/fit/{id}")
    public ResponseEntity<Fitness> getFitnessById(@PathVariable("id") Long fitnessId) {

        Fitness fitness = fitnessService.getFitnessById(fitnessId);
        return new ResponseEntity<>(fitness, HttpStatus.OK);
    }
    @PutMapping("/fit/{id}")
    public ResponseEntity<Fitness> updateFitness(@PathVariable("id") Long fitnessId, @RequestBody Fitness report) {
        Fitness updatedReport = this.fitnessService.updateFitness(fitnessId, report);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFitness(@PathVariable("id") Long fitnessId) {
        fitnessService.deleteFitness(fitnessId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
