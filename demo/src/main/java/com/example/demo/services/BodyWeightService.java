package com.example.demo.services;

import com.example.demo.entities.BodyWeight;
import com.example.demo.repositories.BodyWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BodyWeightService {

    @Autowired
    private BodyWeightRepository bodyWeightRepository;

    public List<BodyWeight> getBodyWeightForMonth(String month, int year){
        return bodyWeightRepository.findByMonthAndYear(month, year);
    }

    public void addWeight(double weight,int day, String month){
        BodyWeight bodyWeight = new BodyWeight();
        bodyWeight.setWeight(weight);
        bodyWeight.setDay(day);
        bodyWeight.setMonth(month);
        bodyWeight.setYear(LocalDate.now().getYear());
        bodyWeightRepository.save(bodyWeight);
    }
}
