package com.assignment.scalable.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.scalable.dto.CarDTO;
import com.assignment.scalable.dto.UserDTO;
import com.assignment.scalable.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path = "/create-user-profile")
	public ResponseEntity<Integer> createUserProfile(@RequestBody UserDTO dto) throws Exception {
		int userId = userService.createUserProfile(dto);
		return new ResponseEntity<>(userId, HttpStatus.OK);
	}

	@PostMapping(path = "/update-user-profile")
	public ResponseEntity<String> updateUserProfile(@RequestBody UserDTO dto) throws Exception {
		return new ResponseEntity<>(userService.updateUserProfile(dto), HttpStatus.OK);
	}

	@PostMapping(path = "/add-car")
	public ResponseEntity<String> addCar(@RequestParam Integer userId, @RequestBody CarDTO dto) throws Exception {
		return new ResponseEntity<String>(userService.addCar(userId, dto), HttpStatus.OK);
	}

	@GetMapping(path = "/get-all-customers")
	public ResponseEntity<List<UserDTO>> getAllCustomers() throws Exception {
		return new ResponseEntity<List<UserDTO>>(userService.getAllCustomers(), HttpStatus.OK);
	}

	// Test APIs 

	@GetMapping(path = "/test-add-car")
	public ResponseEntity<String> testAddCar() throws Exception {
		CarDTO carDto = new CarDTO();
		carDto.setBrand("Honda");
		carDto.setColor("Urban Brown Metallic");
		carDto.setModel("Amaze");
		carDto.setRegistrationNumber("KA07L0125");

		List<CarDTO> carDtoList = new ArrayList<>();
		carDtoList.add(carDto);

		return new ResponseEntity<>(userService.addCar(1, carDto), HttpStatus.OK);
	}

	@GetMapping(path = "/test-create-user-profile")
	public ResponseEntity<Integer> testCreateUserProfile() throws Exception {
		UserDTO dto = new UserDTO();
		dto.setName("ABCD");
		dto.setEmailId("abcd@def.in");
		dto.setPhoneNo("+91 90227 83210");

		CarDTO carDto = new CarDTO();
		carDto.setBrand("Honda");
		carDto.setColor("Urban Brown Metallic");
		carDto.setModel("Amaze");
		carDto.setRegistrationNumber("KA07L0137");

		List<CarDTO> carDtoList = new ArrayList<>();
		carDtoList.add(carDto);
		dto.setCarList(carDtoList);

		int userId = userService.createUserProfile(dto);
		return new ResponseEntity<>(userId, HttpStatus.OK);
	}
}
