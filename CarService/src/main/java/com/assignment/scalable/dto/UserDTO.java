package com.assignment.scalable.dto;

import java.util.List;

public class UserDTO {
	private Integer userId;
	private String name;
	private String emailId;
	private String phoneNo;
	private List<CarDTO> carList;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<CarDTO> getCarList() {
		return carList;
	}

	public void setCarList(List<CarDTO> carList) {
		this.carList = carList;
	}
}
