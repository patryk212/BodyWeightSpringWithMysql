package com.example.demo.controllers;


import com.example.demo.entities.BodyWeight;
import com.example.demo.services.BodyWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodyweights")
@CrossOrigin("http://localhost:8080")
public class BodyWeightController {

    @Autowired
    private BodyWeightService bodyWeightService;

    @GetMapping("/monthly")
    public List<BodyWeight> getAllBodyWeights(@RequestParam String month, @RequestParam int year) {
        return bodyWeightService.getBodyWeightForMonth(month, year);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBodyWeight(@RequestBody BodyWeight bodyWeight) {
        bodyWeightService.addWeight(bodyWeight.getWeight(), bodyWeight.getDay(), bodyWeight.getMonth());
        return new ResponseEntity<>("Weight added successfully", HttpStatus.CREATED);
    }
}