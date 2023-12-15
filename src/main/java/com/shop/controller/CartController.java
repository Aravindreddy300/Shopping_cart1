package com.shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Cart;
import com.shop.exception.CartItemNotFoundException;
import com.shop.exception.CustomerNotFoundException;
import com.shop.service.CartService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService; 

    @PostMapping("{pId}/{cId}/{quantity}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long pId,
                                          @PathVariable Long cId, @PathVariable int quantity
                                          ) {
        Cart cart = cartService.addToCart(pId, cId,quantity);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
}
    @GetMapping
    public List<Cart> getCart(){                                         
        return cartService.getCart();
     }
    
    
   /* @GetMapping("/{customerId}")
    public Cart getCartByCustomerId(@PathVariable Long customerId) {
        Cart cartItems = cartService.getCartByCustomerId(customerId);
        return cartItems;
    }*/
    
    @GetMapping("/{customerId}")
    public Cart getCartByCustomerId(@PathVariable Long customerId) throws CartItemNotFoundException {	
    	if(cartService.getCartByCustomerId(customerId)!=null) {
    		return cartService.getCartByCustomerId(customerId); 
    	}else {
    		throw new CartItemNotFoundException("Cart not found with customer ID "+customerId);
    	}
        
    }
    
}
