package com.cg.go.greatoutdoor.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.go.greatoutdoor.dto.order.CreateOrderRequest;
import com.cg.go.greatoutdoor.dto.order.UpdateOrderRequest;
import com.cg.go.greatoutdoor.entity.OrderEntity;
import com.cg.go.greatoutdoor.entity.ProductEntity;
import com.cg.go.greatoutdoor.service.IProductService;

@Component
public class OrderUtil {

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
	
	public OrderEntity convertToOrder(CreateOrderRequest order) {
		
		Integer totalQuantity=0;
		double totalPrice=0;
		
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setUserId(order.getUserId());
		Map<ProductEntity,Integer> products=convertMap(order.getProducts());
		Set<ProductEntity> productSet=products.keySet();
		for(ProductEntity product:productSet) {
			totalQuantity+=products.get(product);
			totalPrice+=product.getPrice()*products.get(product);
		}
		orderEntity.setProducts(products);
		orderEntity.setTotalPrice(totalPrice);
		orderEntity.setTotalQuantity(totalQuantity);
		orderEntity.setDeliveryDate(order.getDeliveryDate());
		orderEntity.setDispatchDate(order.getDispatchDate());
		return orderEntity;
	}
public OrderEntity convertToOrder(UpdateOrderRequest order) {
		
		Integer totalQuantity=0;
		double totalPrice=0;
		
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setUserId(order.getUserId());
		Map<ProductEntity,Integer> products=convertMap(order.getProducts());
		Set<ProductEntity> productSet=products.keySet();
		for(ProductEntity product:productSet) {
			totalQuantity+=products.get(product);
			totalPrice+=product.getPrice()*products.get(product);
		}
		orderEntity.setProducts(products);
		orderEntity.setTotalPrice(totalPrice);
		orderEntity.setTotalQuantity(totalQuantity);
		orderEntity.setDeliveryDate(order.getDeliveryDate());
		orderEntity.setDispatchDate(order.getDispatchDate());
		return orderEntity;
	}
}
