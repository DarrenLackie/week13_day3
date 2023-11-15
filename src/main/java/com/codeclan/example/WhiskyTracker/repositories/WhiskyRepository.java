package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByAgeEquals(int age);

    List<Whisky> findByAgeAndDistilleryNameEquals(int age, String distillery);

    List<Whisky> findByDistilleryNameEquals(String distillery);

    List<Whisky> findByDistilleryRegionEquals(String region);


}
