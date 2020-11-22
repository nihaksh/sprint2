package com.cg.go.greatoutdoor;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.go.greatoutdoor.dao.ICartItemRepository;
import com.cg.go.greatoutdoor.entity.CartItemEntity;
import com.cg.go.greatoutdoor.service.CartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


@ExtendWith(MockitoExtension.class)
	public class CartItemTests {
		@InjectMocks
		private CartService service;

		@Mock
		private ICartItemRepository cartRepository;
		
		
		@Test
		 void testAddCart()  {
			
			CartItemEntity cartItem = Mockito.mock(CartItemEntity.class);
			CartItemEntity updated=Mockito.mock(CartItemEntity.class);
			Mockito.when(cartRepository.save(cartItem)).thenReturn(updated); 
			CartItemEntity result =service.addCart(cartItem);
			assertEquals(updated,result);

		}
		
		@Test
		void testUpdateCart()  {
			
			CartItemEntity cartItem = Mockito.mock(CartItemEntity.class);
			CartItemEntity updated=Mockito.mock(CartItemEntity.class);
			int cartId=5;
			Mockito.when(cartItem.getCartId()).thenReturn(cartId);
			Mockito.when(cartRepository.existsById(cartId)).thenReturn(true);
				
			Mockito.when(cartRepository.save(cartItem)).thenReturn(updated); 
			CartItemEntity result =service.updateCart(cartItem);
			assertEquals(updated,result);

		}
		
}