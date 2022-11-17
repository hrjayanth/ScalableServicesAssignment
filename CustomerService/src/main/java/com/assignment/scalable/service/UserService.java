package com.assignment.scalable.service;

import java.util.List;

import com.assignment.scalable.dto.CarDTO;
import com.assignment.scalable.dto.UserDTO;

public interface UserService {

	Integer createUserProfile(UserDTO dto) throws Exception;

	String updateUserProfile(UserDTO dto) throws Exception;

	String addCar(Integer userId, CarDTO dto) throws Exception;

	List<UserDTO> getAllCustomers() throws Exception;

}
