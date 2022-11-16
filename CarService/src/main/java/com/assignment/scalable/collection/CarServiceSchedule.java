package com.assignment.scalable.collection;

import java.util.Date;

import com.assignment.scalable.db.annotations.Collection;
import com.assignment.scalable.db.utils.MongoConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

@Collection(name = "car_service_schedule", database = MongoConstants.CARSERVICEDATABASE)
public class CarServiceSchedule {
	@JsonProperty("_id")
	private Object _id;
	private Date serviceDate;
	private String carRegistrationId;
	private String ownerContactNumber;

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

	public String getCarRegistrationId() {
		return carRegistrationId;
	}

	public void setCarRegistrationId(String carRegistrationId) {
		this.carRegistrationId = carRegistrationId;
	}

	public String getOwnerContactNumber() {
		return ownerContactNumber;
	}

	public void setOwnerContactNumber(String ownerContactNumber) {
		this.ownerContactNumber = ownerContactNumber;
	}

}
