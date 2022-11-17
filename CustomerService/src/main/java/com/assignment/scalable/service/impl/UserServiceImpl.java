package com.assignment.scalable.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.scalable.collection.Car;
import com.assignment.scalable.collection.User;
import com.assignment.scalable.dao.CarDAO;
import com.assignment.scalable.dao.UserDAO;
import com.assignment.scalable.db.utils.MongoUtil;
import com.assignment.scalable.dto.CarDTO;
import com.assignment.scalable.dto.UserDTO;
import com.assignment.scalable.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;

	@Autowired
	CarDAO carDao;

	/**
	 * Returns UserId if profile creation is successful
	 */
	@Override
	public Integer createUserProfile(UserDTO dto) throws Exception {
		User user = new User();
		user.setEmailId(dto.getEmailId());
		user.setName(dto.getName());
		user.setPhoneNo(dto.getPhoneNo());
		int userId = MongoUtil.getUniqueId();
		user.setUserId(userId);

		userDao.insert(user);

		if (dto.getCarList() != null) {
			for (CarDTO carDto : dto.getCarList()) {
				this.addCar(userId, carDto);
			}
		}

		return user.getUserId();
	}

	@Override
	public String updateUserProfile(UserDTO dto) throws Exception {
		Map<String, Object> criteriaMap = new HashMap<>();
		criteriaMap.put("userId", dto.getUserId());

		User user = userDao.findOne(criteriaMap);
		user.setEmailId(dto.getEmailId());
		user.setName(dto.getName());
		user.setPhoneNo(dto.getPhoneNo());

		userDao.update(criteriaMap, user);
		return "SUCCESS";
	}

	@Override
	public String addCar(Integer ownerId, CarDTO dto) throws Exception {
		Car car = new Car();
		car.setBrand(dto.getBrand());
		car.setColor(dto.getColor());
		car.setModel(dto.getModel());
		car.setRegistrationNumber(dto.getRegistrationNumber());
		car.setOwnerId(ownerId);

		carDao.insert(car);
		return "SUCCESS";
	}

	@Override
	public List<UserDTO> getAllCustomers() throws Exception {
		Map<String, Object> criteriaMap = new HashMap<>();
		List<User> userList = userDao.find(criteriaMap);

		List<UserDTO> userDtoList = new ArrayList<>();
		for (User user : userList) {
			UserDTO userDto = new UserDTO();
			userDto.setEmailId(user.getEmailId());
			userDto.setName(user.getName());
			userDto.setPhoneNo(user.getPhoneNo());
			userDto.setUserId(user.getUserId());

			criteriaMap = new HashMap<>();
			criteriaMap.put("ownerId", user.getUserId());
			List<Car> carList = carDao.find(criteriaMap);

			List<CarDTO> carDtoList = new ArrayList<>();
			for (Car car : carList) {
				CarDTO carDto = new CarDTO();
				carDto.setBrand(car.getBrand());
				carDto.setColor(car.getColor());
				carDto.setModel(car.getModel());
				carDto.setRegistrationNumber(car.getRegistrationNumber());

				carDtoList.add(carDto);
			}

			userDto.setCarList(carDtoList);
			userDtoList.add(userDto);
		}

		return userDtoList;
	}
}
