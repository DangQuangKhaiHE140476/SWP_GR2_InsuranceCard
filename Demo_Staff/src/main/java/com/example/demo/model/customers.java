package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String socialsecuritynumber;
	private Date dob;
	private boolean gender;
	private String address;
	private String phonenumber;
	private String email;
	private String username;
	private String password;
	private Long roleid;
	
	
	
	public customers() {
		super();
	}



	public customers(Long id, String name, String socialsecuritynumber, Date dob, boolean gender, String address,
			String phonenumber, String email, String username, String password, Long roleid) {
		super();
		this.id = id;
		this.name = name;
		this.socialsecuritynumber = socialsecuritynumber;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSocialsecuritynumber() {
		return socialsecuritynumber;
	}



	public void setSocialsecuritynumber(String socialsecuritynumber) {
		this.socialsecuritynumber = socialsecuritynumber;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public boolean isGender() {
		return gender;
	}



	public void setGender(boolean gender) {
		this.gender = gender;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Long getRoleid() {
		return roleid;
	}



	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	
	
}
