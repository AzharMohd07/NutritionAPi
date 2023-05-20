package com.example.demo.service;

import com.example.demo.entity.Fitness;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FitnessValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Fitness.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Fitness fitness = (Fitness) target;

        if (fitness.getCaloriesBurned() == null) {
            errors.rejectValue("caloriesBurned", "field.required", "Calories burned is required");
        } else if (fitness.getCaloriesBurned() < 0) {
            errors.rejectValue("caloriesBurned", "field.invalid", "Calories burned must be a positive value");
        }

        if (fitness.getTotalKmWalked() == null) {
            errors.rejectValue("totalKmWalked", "field.required", "Total km walked is required");
        } else if (fitness.getTotalKmWalked() < 0) {
            errors.rejectValue("totalKmWalked", "field.invalid", "Total km walked must be a positive value");
        }

        if (fitness.getPulseRate() == null) {
            errors.rejectValue("pulseRate", "field.required", "Pulse rate is required");
        } else if (fitness.getPulseRate() < 0) {
            errors.rejectValue("pulseRate", "field.invalid", "Pulse rate must be a positive value");
        }

    }
}
