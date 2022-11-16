package com.assignment.scalable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.scalable.dto.CarDTO;
import com.assignment.scalable.dto.UserDTO;
import com.assignment.scalable.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path = "/create-user-profile")
	public ResponseEntity<Integer> createUserProfile(UserDTO dto) throws Exception {
		int userId = userService.createUserProfile(dto);
		return new ResponseEntity<>(userId, HttpStatus.OK);
	}

	@PostMapping(path = "/update-user-profile")
	public ResponseEntity<Boolean> updateUserProfile(UserDTO dto) throws Exception {
		userService.updateUserProfile(dto);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	public ResponseEntity<Boolean> addCar(CarDTO dto) throws Exception {
		return new ResponseEntity<Boolean>(userService.addCar(dto), HttpStatus.OK);
	}
}
