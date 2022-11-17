package com.assignment.scalable.collection;

import com.assignment.scalable.db.annotations.Collection;
import com.assignment.scalable.db.utils.MongoConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

@Collection(name = "customer", database = MongoConstants.CUSTOMERDATABASE)
public class User {

	@JsonProperty("_id")
	private Object _id;

	private Integer userId;

	private String name;

	private String emailId;

	private String phoneNo;

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

	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = _id;
	}

}
