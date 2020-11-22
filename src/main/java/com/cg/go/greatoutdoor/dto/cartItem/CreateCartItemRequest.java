package com.cg.go.greatoutdoor.dto.cartItem;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.cg.go.greatoutdoor.entity.Userdata;


public class CreateCartItemRequest {
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Userdata userId;
	private Map<Integer,Integer> products; // productIds,Quantity
	
	public CreateCartItemRequest() {
		
	}
	public Userdata getUserId() {
		return userId;
	}
	public void setUserId(Userdata userId) {
		this.userId = userId;
	}
	public Map<Integer, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<Integer, Integer> products) {
		this.products = products;
	}
	
	
}
