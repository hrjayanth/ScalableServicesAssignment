package com.assignment.scalable.service;

import java.util.Date;

public interface CarService {

	String scheduleCarService(String carId, Date serviceDate) throws Exception;

	String getCarServiceStatus(String carId) throws Exception;
}
