package com.cg.go.greatoutdoor.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.go.greatoutdoor.dto.cartItem.CreateCartItemRequest;
import com.cg.go.greatoutdoor.dto.cartItem.UpdateCartItemRequest;
import com.cg.go.greatoutdoor.entity.CartItemEntity;
import com.cg.go.greatoutdoor.entity.ProductEntity;
import com.cg.go.greatoutdoor.service.IProductService;

@Component
public class CartItemUtil {
	
	@Autowired
	public IProductService productService;
	
	public Map<ProductEntity,Integer> convertMap(Map<Integer,Integer> map){
		Set<Integer> ids=map.keySet();
		Map<ProductEntity,Integer> products=new HashMap<>();
		for(Integer id:ids) {
			ProductEntity productEntity=productService.findByProductId(id);
			products.put(productEntity,map.get(id));
		}
		return products;
	}
	
	
	public CartItemEntity convertToCartItem(CreateCartItemRequest cartItem) {
	
		Integer totalQuantity=0;
		double totalPrice=0;
		
		CartItemEntity cart=new CartItemEntity();
		cart.setUserId(cartItem.getUserId());
		Map<ProductEntity,Integer> products=convertMap(cartItem.getProducts());
		Set<ProductEntity> productSet=products.keySet();
		for(ProductEntity product:productSet) {
			totalQuantity+=products.get(product);
			totalPrice+=product.getPrice()*products.get(product);
		}
		cart.setProducts(products);
		cart.setCartTotalPrice(totalPrice);
		cart.setTotalQuantity(totalQuantity);
		return cart;
	}

	public CartItemEntity convertToCartItem(UpdateCartItemRequest cartItem) {
		Integer totalQuantity=0;
		double totalPrice=0;
		CartItemEntity cart=new CartItemEntity();
		cart.setUserId(cartItem.getUserId());
		Map<ProductEntity,Integer> products=convertMap(cartItem.getProducts());
		Set<ProductEntity> productSet=products.keySet();
		for(ProductEntity product:productSet) {
			totalQuantity+=products.get(product);
			totalPrice+=product.getPrice()*products.get(product);
		}
		cart.setProducts(products);
		cart.setCartTotalPrice(totalPrice);
		cart.setTotalQuantity(totalQuantity);
		return cart;
	}
}
