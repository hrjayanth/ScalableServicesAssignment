package com.assignment.scalable.service.impl;

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
		user.setPhoneNo(dto.getName());
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
	public Boolean updateUserProfile(UserDTO dto) throws Exception {

		return true;
	}

	@Override
	public Boolean addCar(Integer ownerId, CarDTO dto) throws Exception {
		Car car = new Car();
		car.setBrand(dto.getBrand());
		car.setColor(dto.getColor());
		car.setModel(dto.getModel());
		car.setRegistrationNumber(dto.getRegistrationNumber());
		car.setOwnerId(ownerId);

		carDao.insert(car);
		return true;
	}
}
