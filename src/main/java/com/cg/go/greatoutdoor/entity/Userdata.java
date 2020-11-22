package com.cg.go.greatoutdoor.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Users")
@Entity
public class Userdata {
	
	@GeneratedValue
	@Id
	private Integer userId;
	private String userName;
	private String userType;
	private String userPassword;
	
	public Userdata() {
		
	}
	public Userdata(String userName, String userType, String userPassword) {
		
		this.userName = userName;
		this.userType = userType;
		this.userPassword = userPassword;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public int hashCode() {
		int hash=Objects.hashCode(userId);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Userdata other = (Userdata) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
	
}
	