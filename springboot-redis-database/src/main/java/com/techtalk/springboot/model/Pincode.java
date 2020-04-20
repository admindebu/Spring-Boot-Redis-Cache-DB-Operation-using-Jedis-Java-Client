package com.techtalk.springboot.model;

import java.io.Serializable;

public class Pincode implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String pincodeVal;
	private String stateName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPincodeVal() {
		return pincodeVal;
	}

	public void setPincodeVal(String pincodeVal) {
		this.pincodeVal = pincodeVal;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}