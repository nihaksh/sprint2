package com.cg.go.greatoutdoor.dto.user;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CreateUserRequest {

	private String userName;
	private String userType;
	private String userPassword;
	
	public CreateUserRequest() {
		
	}
	public CreateUserRequest(String userName, String userType, String userPassword) {
		
		this.userName = userName;
		this.userType = userType;
		this.userPassword = userPassword;
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
}
