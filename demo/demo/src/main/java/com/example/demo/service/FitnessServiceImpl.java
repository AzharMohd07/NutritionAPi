package com.example.demo.service;

import com.example.demo.entity.Fitness;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FitnessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessServiceImpl implements FitnessService{

    private final FitnessRepository fitnessRepository;

    public FitnessServiceImpl(FitnessRepository fitnessRepository) {
        this.fitnessRepository = fitnessRepository;
    }
    @Override
    public Fitness createFitness(Fitness fitness) {
        return fitnessRepository.save(fitness);
    }

    @Override
    public Fitness updateFitness(Long fitnessId, Fitness report){
        Fitness fitness= fitnessRepository.findById(fitnessId).get();
        fitness.setCaloriesBurned(report.getCaloriesBurned());
        fitness.setTotalKmWalked(report.getTotalKmWalked());
        fitness.setPulseRate(report.getPulseRate());

        return fitnessRepository.save(fitness);

    }
    @Override
    public Fitness getLatestFitness() {
        return fitnessRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public List<Fitness> getAllFitness(){
        return fitnessRepository.findAll();

    }

    @Override
    public Fitness getFitnessById(Long fitnessId){
        return fitnessRepository.findById(fitnessId)
                .orElseThrow(() -> new ResourceNotFoundException("Report", "id", fitnessId));

    }

    @Override
    public void deleteFitness(Long fitnessId){
        fitnessRepository.deleteById(fitnessId);

    }


}
