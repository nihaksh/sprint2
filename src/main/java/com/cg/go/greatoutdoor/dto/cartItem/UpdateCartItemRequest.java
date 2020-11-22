package com.cg.go.greatoutdoor.dto.cartItem;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.cg.go.greatoutdoor.entity.Userdata;


public class UpdateCartItemRequest {
	
	@Id
	private Integer cartId;
	@OneToOne(cascade = {CascadeType.ALL})
	private Userdata userId;
	private Map<Integer,Integer> products;  // productIds,Quantity
	
	
	public UpdateCartItemRequest() {
		
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
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	
}
