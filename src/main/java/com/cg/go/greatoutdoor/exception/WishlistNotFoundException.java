package com.cg.go.greatoutdoor.exception;

public class WishlistNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WishlistNotFoundException(){

    }

    public WishlistNotFoundException(String msg){
        super(msg);
    }
}
