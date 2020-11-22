package com.cg.go.greatoutdoor.dto.order;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.cg.go.greatoutdoor.entity.ProductEntity;
import com.cg.go.greatoutdoor.entity.Userdata;

public class OrderDetails {
	
	@Id
	private Integer orderId;
	@OneToOne(cascade = {CascadeType.ALL})
	private Userdata userId;
	@ElementCollection
	private Map<ProductEntity,Integer> products; // products,Quantity
	
	private double totalPrice;
	private long totalQuantity;
	private LocalDate dispatchDate;
	private LocalDate deliveryDate;
	public OrderDetails(Integer orderId, Userdata userdata, double totalPrice,
			long totalQuantity, Map<ProductEntity,Integer> products,LocalDate dispatchDate, LocalDate deliveryDate) {
		this.orderId = orderId;
		this.userId = userdata;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.products=products;
		this.dispatchDate = dispatchDate;
		this.deliveryDate = deliveryDate;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Userdata getUserId() {
		return userId;
	}
	public void setUserId(Userdata userId) {
		this.userId = userId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Map<ProductEntity, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<ProductEntity, Integer> products) {
		this.products = products;
	}
	
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
