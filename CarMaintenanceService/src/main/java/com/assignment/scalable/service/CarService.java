package com.assignment.scalable.service;

import java.util.Date;
import java.util.List;

import com.assignment.scalable.dto.CarServiceDTO;

public interface CarService {

	String scheduleCarService(String carId, Date serviceDate) throws Exception;

	CarServiceDTO getCarServiceStatus(String carId) throws Exception;

	List<CarServiceDTO> getCarServiceHistory(String carId) throws Exception;
}
