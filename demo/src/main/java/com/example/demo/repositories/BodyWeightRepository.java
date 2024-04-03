package com.example.demo.repositories;

import com.example.demo.entities.BodyWeight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodyWeightRepository extends JpaRepository<BodyWeight, Integer> {

    List<BodyWeight> findByMonthAndYear(String month, int year);

}
