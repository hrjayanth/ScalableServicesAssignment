package com.assignment.scalable.collection;

import com.assignment.scalable.db.annotations.Collection;
import com.assignment.scalable.db.utils.MongoConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

@Collection(name = "car", database = MongoConstants.CUSTOMERDATABASE)
public class Car {

	@JsonProperty("_id")
	private Object _id;
	private String registrationNumber;
	private String brand;
	private String model;
	private String color;
	private Integer ownerId;

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

	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}


}
