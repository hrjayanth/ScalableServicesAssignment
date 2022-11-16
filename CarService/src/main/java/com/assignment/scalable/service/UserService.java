package com.assignment.scalable.service;

import com.assignment.scalable.dto.UserDTO;

public interface UserService {

	Integer createUserProfile(UserDTO dto) throws Exception;

	Boolean updateUserProfile(UserDTO dto) throws Exception;

}
