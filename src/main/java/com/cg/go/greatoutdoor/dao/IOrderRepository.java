package com.cg.go.greatoutdoor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.go.greatoutdoor.entity.OrderEntity;

public interface IOrderRepository extends JpaRepository<OrderEntity,Integer>{
	
	
	
	 //public List<OrderEntity> findOrdersByUserId(Integer userId); //public void
	/* * updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate);
	 */
}
