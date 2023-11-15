package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindAllWhiskiesByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByAgeEquals(12);
        assertFalse(foundWhiskies.isEmpty());
	}

	@Test
	public void canFindAllDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegionEquals("Island");
		assertFalse(foundDistilleries.isEmpty());
	}

	@Test
	public void getAllWhiskyFromDistilleryByAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findByAgeAndDistilleryNameEquals(12,"The Glenlivet");
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	public void getAllWhiskyFromRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegionEquals("Highland");
        assertFalse(foundWhiskies.isEmpty());
	}

	@Test
	public void getDistilleryOf12YearOldWhiskies(){
		List<Distillery> foundDistilleries = distilleryRepository.findByWhiskiesAge(12);
		assertFalse(foundDistilleries.isEmpty());
	}

}
