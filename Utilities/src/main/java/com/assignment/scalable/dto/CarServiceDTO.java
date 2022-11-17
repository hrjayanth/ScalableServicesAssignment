package com.assignment.scalable.dto;

import java.util.Date;

public class CarServiceDTO {

	private Date serviceDate;
	private Double serviceCost;
	private Date nextServiceDate;
	private boolean freeService;
	private String serviceStatus;

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public Double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(Double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public Date getNextServiceDate() {
		return nextServiceDate;
	}

	public void setNextServiceDate(Date nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}

	public boolean isFreeService() {
		return freeService;
	}

	public void setFreeService(boolean freeService) {
		this.freeService = freeService;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	
}
