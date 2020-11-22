package com.cg.go.greatoutdoor.exception;

public class UserAlreadyExistsException extends RuntimeException{

	public UserAlreadyExistsException (String msg) {
		super(msg);
	}
	
	public UserAlreadyExistsException () {
		
	}
}
