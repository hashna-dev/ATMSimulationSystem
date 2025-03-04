package com.ty.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class LoginData {
	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotBlank(message = "Name cannot be null")
	@Size(min=3,max=15,message="Name should be between 3 to 15 characters")
	private String name;
	private String email;
	private String password;
	private String location;
	private long phno;
	@AssertTrue(message="Agree the terms and conditions")
	public boolean agreed;
	
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "LoginData [name=" + name + ", email=" + email + ", password=" + password + ", location=" + location
				+ ", phno=" + phno + "]";
	}
	
	
}
