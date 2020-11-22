package com.cg.go.greatoutdoor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.dao.ICartItemRepository;
import com.cg.go.greatoutdoor.entity.CartItemEntity;
import com.cg.go.greatoutdoor.exception.CartException;

@Service
public class CartService implements ICartService{
	
	
	@Autowired
	private ICartItemRepository cartRepository;

	
	
	//Adding CartItemEntity if record not exists in the table
		@Override
		public CartItemEntity addCart(CartItemEntity cartItemEntity) {
			boolean exists=cartItemEntity.getCartId()!=null && cartRepository.existsById(cartItemEntity.getCartId());
	        if(exists){
	            throw new CartException("Cart already exists for id="+cartItemEntity.getCartId());
	        }
	        CartItemEntity cartItem=cartRepository.save(cartItemEntity);
			return cartItem;
		}
	

		
		//Updating fields of CartItemEntity if record exists in the table
		@Override
		public CartItemEntity updateCart(CartItemEntity cartItemEntity) {
			boolean exists=cartItemEntity.getCartId()!=null && cartRepository.existsById(cartItemEntity.getCartId());
	        if(!exists){
	            throw new CartException("Cart does not exists for id="+cartItemEntity.getCartId());
	        }
	        CartItemEntity cartItem=cartRepository.save(cartItemEntity);
			return cartItem;
		}

	
	//CartList based on userId
	@Override
	public List<CartItemEntity> findCartlist(Integer userId) {
		List<CartItemEntity> list=cartRepository.findByUserId(userId);
		if(list.size()==0) {
			throw new CartException("There is no cartItem with userId="+userId);
		}
		return list;
	}
	
	//To retreive all cartItems
	@Override
	public List<CartItemEntity> findallCartItems() {
		List<CartItemEntity> list=cartRepository.findAll();
		
		return list;
	}

	

	
	//Deletion of records based on userId
	@Override
	public void deleteCartlist(Integer userId) {
		List<CartItemEntity> list=findCartlist(userId);
		for(CartItemEntity cartItem:list) {
			cartRepository.delete(cartItem);
		}
	}
	
	//Finding the record based on cartId
		private CartItemEntity findByCartId(Integer cartId) {
			Optional<CartItemEntity> optional=cartRepository.findById(cartId);
			if(!optional.isPresent())
				throw new CartException("Cart does not exists for id="+cartId);
			CartItemEntity cartItemEntity=optional.get();
			return cartItemEntity;
		}
		
	


}
