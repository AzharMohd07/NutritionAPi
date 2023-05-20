package com.example.demo.repository;

import com.example.demo.entity.Fitness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FitnessRepository extends JpaRepository<Fitness, Long> {

    Fitness findFirstByOrderByIdDesc();

    List<Fitness> findAll();
}
