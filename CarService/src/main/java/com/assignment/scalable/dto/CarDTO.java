package com.assignment.scalable.dto;

import java.util.List;

public class CarDTO {
	private String registrationNumber;
	private String brand;
	private String model;
	private String color;
	private List<CarServiceDTO> carServiceHistory;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<CarServiceDTO> getCarServiceHistory() {
		return carServiceHistory;
	}

	public void setCarServiceHistory(List<CarServiceDTO> carServiceHistory) {
		this.carServiceHistory = carServiceHistory;
	}

}
