package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//        Get all the whiskies for a particular year
//        Get all the distilleries for a particular region
//        Get all the whisky from a particular distillery that's a specific age


@RestController
public class WhiskyController {


    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies/{age}")
    public ResponseEntity<List<Whisky>> canGetWhiskiesByAge(@PathVariable int age){
        return new ResponseEntity<>(whiskyRepository.findByAgeEquals(age), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/distilleries")
    public ResponseEntity<List<Whisky>> getWhiskyByAgeFromDistillery(@RequestParam(name="age", required = false) Integer age, @RequestParam(name="distillery", required = false) String distillery) {
        if (distillery != null)
            if (age != null) {
                return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryNameEquals(age, distillery), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(whiskyRepository.findByDistilleryNameEquals(distillery), HttpStatus.OK);
            }
        else {
            if (age != null){
                return new ResponseEntity<>(whiskyRepository.findByAgeEquals(age), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

    @GetMapping(value = "/whiskies/distilleries/")
    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@RequestParam(name="region") String region){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegionEquals(region), HttpStatus.OK);
    }
}
