package com.validtest.model;

import java.io.Serializable;
import java.util.List;


public class ResponseModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4309202393056841862L;
	private String message;
	private transient List<?> data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	
	
	
	

}
