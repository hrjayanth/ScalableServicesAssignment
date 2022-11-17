package com.assignment.scalable.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.scalable.dto.CarServiceDTO;
import com.assignment.scalable.service.CarService;

@RestController
public class CarController {

	@Autowired
	CarService carService;

	@PostMapping(path = "/schedule-car-service")
	public ResponseEntity<String> scheduleCarService(@RequestParam String carId, @RequestParam String serviceDate) throws Exception {
		Date date = new Date();
		return new ResponseEntity<String>(carService.scheduleCarService(carId, date), HttpStatus.OK);
	}

	@GetMapping(path = "/get-car-service-status")
	public ResponseEntity<CarServiceDTO> getCarServiceStatus(@RequestParam String carId) throws Exception {
		return new ResponseEntity<CarServiceDTO>(carService.getCarServiceStatus(carId), HttpStatus.OK);
	}

	@GetMapping(path = "/get-car-service-history")
	public ResponseEntity<List<CarServiceDTO>> getCarServiceHistory(@RequestParam String carId) throws Exception {
		return new ResponseEntity<List<CarServiceDTO>>(carService.getCarServiceHistory(carId), HttpStatus.OK);
	}
	
	// Test
	@GetMapping(path = "/test-schedule-car-service")
	public ResponseEntity<String> testScheduleCarService() throws Exception {
		System.out.println("Here");
		String carId = "KA07L0137";
		Date serviceDate = new Date();
		return new ResponseEntity<String>(carService.scheduleCarService(carId, serviceDate), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<String> test() throws Exception {
		System.out.println("Hello World!!");
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	} 
}
