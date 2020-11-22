package com.cg.go.greatoutdoor.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.dto.order.CreateOrderRequest;
import com.cg.go.greatoutdoor.dto.order.OrderDetails;
import com.cg.go.greatoutdoor.dto.order.UpdateOrderRequest;
import com.cg.go.greatoutdoor.entity.OrderEntity;
import com.cg.go.greatoutdoor.service.IOrderService;
import com.cg.go.greatoutdoor.util.OrderUtil;


@RequestMapping("/orderstable")
@RestController

public class OrderController {
	
	@Autowired
	public IOrderService orderService;
	
	@Autowired
	private OrderUtil orderUtil;
	
	/**
     * effective url will be http://localhost:8585/orderstable/add
     */
	
	// Add orders using the order entity table
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public OrderDetails add(@RequestBody CreateOrderRequest requestData) {
    	OrderEntity order = orderUtil.convertToOrder(requestData);
    	order = orderService.addOrder(order);
        OrderDetails details = toDetails(order);
        return details;
    }
 
 // Update DispatchDate and arrivalDate based on orderID in the table
	@PutMapping("/update")
    public OrderDetails update(@RequestBody UpdateOrderRequest requestData) {
    	OrderEntity order = orderUtil.convertToOrder(requestData);
		order.setOrderId(requestData.getOrderId());
		order=orderService.updateDate(order.getOrderId(),order.getDispatchDate(),order.getDeliveryDate());
		OrderDetails details=toDetails(order);
		return details;

    }
	private OrderDetails toDetails(OrderEntity order) {
		OrderDetails orderDetails=new OrderDetails(order.getOrderId(),order.getUserId(),order.getTotalPrice(),order.getTotalQuantity(),order.getProducts(),order.getDispatchDate(),order.getDeliveryDate());
	return orderDetails;
}

	// Find all the required orders in the order table
    @GetMapping("/allOrders")
    public List<OrderDetails> findAllOrders() {
        List<OrderEntity> order = orderService.findAllOrders();
        List<OrderDetails> details = toDetails(order);
        return details;
    }
    private List<OrderDetails> toDetails(List<OrderEntity> orders) {
    	List<OrderDetails> orderDetails=new ArrayList<>();
    	for(OrderEntity order:orders) {
    		OrderDetails details=toDetails(order);
    		orderDetails.add(details);
    	}
		return orderDetails;
	}

	// Find the orders based on the user Id in the orders table
    @GetMapping("/OrdersById/{id}")
    public Optional<OrderEntity> findOrdersById(@PathVariable Integer id) {
        return orderService.findOrdersByUserId(id);
    }
    
    // Deleting the orders based on the order ID in the table
	@DeleteMapping("/remove/{id}")
    public String deleteOrder(@PathVariable("id") Integer OrderId) {
        orderService.deleteOrderById(OrderId);
        String response = "removed order with id=" + OrderId;
        return response;
    }
	// Deleting all orders in the orders table
	@DeleteMapping("/remove")
	public String deleteAll() {
		orderService.deleteAllOrders();
		return "all orders deleted";
	}
}
