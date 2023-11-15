package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> findAllByRegion(@RequestParam(name="region") String name){
        return new ResponseEntity<>(distilleryRepository.findByRegionEquals(name), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/whiskies")
    public ResponseEntity<List<Distillery>> getAllDistilleriesWith12YearOldWhisky(@RequestParam(name="age") int age){
        return new ResponseEntity<>(distilleryRepository.findByWhiskiesAge(age),HttpStatus.OK);
    }


}
