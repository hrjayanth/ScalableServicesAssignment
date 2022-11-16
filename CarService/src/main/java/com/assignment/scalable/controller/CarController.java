package com.assignment.scalable.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.scalable.service.CarService;

@RestController
public class CarController {

	@Autowired
	CarService carService;

	@PostMapping(path = "/schedule-car-service")
	public ResponseEntity<String> scheduleCarService(String carId, Date serviceDate) throws Exception {
		return new ResponseEntity<String>(carService.scheduleCarService(carId, serviceDate), HttpStatus.OK);
	}

	@GetMapping(path = "/get-car-service-status")
	public ResponseEntity<String> getCarServiceStatus(String carId) throws Exception {
		return new ResponseEntity<String>(carService.getCarServiceStatus(carId), HttpStatus.OK);
	}
}
