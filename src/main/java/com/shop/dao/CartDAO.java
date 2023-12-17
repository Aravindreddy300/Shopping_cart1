package com.shop.dao;

import com.shop.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartDAO {
    
    // Adds a product to the cart for a specific customer
    Cart addToCart(Long productId, Long customerId, int quantity);
    
    // Retrieves the entire cart
    List<Cart> getCart();
    
    // Retrieves the cart for a specific customer
    Cart getCartByCustomerId(Long customerId);
}
