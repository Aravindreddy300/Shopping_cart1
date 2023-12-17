package com.shop.dao;

import com.shop.entity.Order;

import java.util.List;

public interface OrderDAO {
    
    // Retrieves a list of orders for a specific customer
    List<Order> getOrdersByCustomerId(Long cId);
    
    // Creates a new order for a specific customer
    Order createOrder(Long cId);
}
