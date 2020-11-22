package com.cg.go.greatoutdoor.service;
import java.util.List;

import com.cg.go.greatoutdoor.entity.CartItemEntity;


public interface ICartService {
	
	public CartItemEntity addCart(CartItemEntity cartItemEntity);
	
	public List<CartItemEntity> findCartlist(Integer userId);

	public CartItemEntity updateCart(CartItemEntity cartItemEntity);
	
	public void deleteCartlist(Integer userId);

	public List<CartItemEntity> findallCartItems();

}
