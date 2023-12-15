package com.shop.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Customer;
import com.shop.entity.Order;
import com.shop.exception.CustomerNotFoundException;
import com.shop.exception.OrderNotFoundException;
import com.shop.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	 private final OrderService orderService;

	    @Autowired
	    public OrderController(OrderService orderService) {
	        this.orderService = orderService;
	    }

   /* @PostMapping("/{cId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long cId, @PathVariable Long pId) {
        Order order = orderService.createOrder(cId, pId);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }*/
    
    @GetMapping("/{cId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable Long cId) {
    	if(orderService.getOrdersByCustomerId(cId)!=null) {
        List<Order> orders = orderService.getOrdersByCustomerId(cId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    	}else {
    		throw new OrderNotFoundException("Orders not found with customerID"+cId);
    	}
    }
    
    
    @PostMapping("/{cId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long cId) {
        Order order = orderService.createOrder(cId);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    
    
}
