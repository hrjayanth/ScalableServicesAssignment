package com.assignment.scalable.collection;

import java.util.Date;

import com.assignment.scalable.db.annotations.Collection;
import com.assignment.scalable.db.utils.MongoConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

@Collection(name = "car_service_history", database = MongoConstants.CARSERVICEDATABASE)
public class CarServiceHistory {

	@JsonProperty("_id")
	private Object _id;
	private Date serviceDate;
	private Double serviceCost;
	private Date nextServiceDate;
	private boolean freeService;
	private String carRegistrationNumber;

	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

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

	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

}
