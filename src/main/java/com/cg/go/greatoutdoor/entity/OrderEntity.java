package com.cg.go.greatoutdoor.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
@Entity
public class OrderEntity {
	@GeneratedValue
	@Id
	private Integer orderId;
	@OneToOne(cascade = {CascadeType.ALL})
	private Userdata userId;
	private double totalPrice;
	@ElementCollection
	private Map<ProductEntity,Integer> products; // products,Quantity
	private long totalQuantity;
	private LocalDate dispatchDate;
	private LocalDate deliveryDate;
	public OrderEntity(Userdata userId, double totalPrice,
			long totalQuantity, Map<ProductEntity,Integer> products,LocalDate dispatchDate, LocalDate deliveryDate) {
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.totalQuantity = totalQuantity;
		this.products=products;
		this.dispatchDate = dispatchDate;
		this.deliveryDate = deliveryDate;
	}
	public OrderEntity() {
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
	@Override
	public int hashCode() {
		int hash=Objects.hashCode(orderId);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntity other = (OrderEntity) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	public Map<ProductEntity,Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<ProductEntity, Integer> products2) {
		this.products = products2;
	}

}
