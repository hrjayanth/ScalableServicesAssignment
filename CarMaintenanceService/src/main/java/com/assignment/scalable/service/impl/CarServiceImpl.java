package com.assignment.scalable.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.scalable.collection.CarServiceSchedule;
import com.assignment.scalable.dao.CarScheduleDAO;
import com.assignment.scalable.dao.CarServiceHistoryDAO;
import com.assignment.scalable.dto.CarServiceDTO;
import com.assignment.scalable.service.CarService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarScheduleDAO carScheduleDao;

	@Autowired
	CarServiceHistoryDAO carServiceHistoryDao;

	@Autowired
	private EurekaClient eurekaClient;

	@Override
	public String scheduleCarService(String carId, Date serviceDate) throws Exception {

		CarServiceSchedule carServiceSchedule = new CarServiceSchedule();
		carServiceSchedule.setCarRegistrationId(carId);
		carServiceSchedule.setServiceDate(serviceDate);

		InstanceInfo service = eurekaClient.getApplication("CUSTOMER SERVICE").getInstances().get(0);

		String hostName = service.getHostName();
		int port = service.getPort();

		System.out.println("hostName: " + hostName);
		System.out.println("port: " + port);

		// Get this information from the Customer Database
		carServiceSchedule.setOwnerContactNumber("12345");

		carScheduleDao.insert(carServiceSchedule);
		
		return "Schedule Confirmed";
	}

	@Override
	public String getCarServiceStatus(String carId) throws Exception {
		return null;
	}

	@Override
	public List<CarServiceDTO> getCarServiceHistory(String carId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
