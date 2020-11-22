package com.cg.go.greatoutdoor.dto.user;

import java.util.Optional;

import com.cg.go.greatoutdoor.entity.Userdata;

public class UserSignUpResponse {
	
	
	private String message;
	 private Optional<Userdata> userDetails;

	    public UserSignUpResponse( String message, Optional<Userdata> userDetails) {
	      
	        this.message = message;
	        this.userDetails = userDetails;
	    }


	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public Optional<Userdata> getUserDetails() {
	        return userDetails;
	    }

	    public void setUserDetails(Optional<Userdata> userDetails) {
	        this.userDetails = userDetails;
	    }
	}

