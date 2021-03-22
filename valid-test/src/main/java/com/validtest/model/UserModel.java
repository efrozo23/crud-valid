package com.validtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "usuarios")
public class UserModel {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "id_user_key")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "lastname")
	@JsonProperty("lastname")
	private String lastName;
	@Column(name = "status")
	private boolean status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
