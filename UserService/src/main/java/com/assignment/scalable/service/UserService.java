package com.assignment.scalable.service;

import java.util.List;

import com.assignment.scalable.dto.CarDTO;
import com.assignment.scalable.dto.UserDTO;

public interface UserService {

	Integer createUserProfile(UserDTO dto) throws Exception;

	Boolean updateUserProfile(UserDTO dto) throws Exception;

	Boolean addCar(Integer userId, CarDTO dto) throws Exception;

	List<UserDTO> getAllCustomers() throws Exception;

}
