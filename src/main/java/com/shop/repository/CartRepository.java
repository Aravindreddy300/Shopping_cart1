package com.shop.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    // Custom query method to find carts by customer Id
   // List<Cart> findByCId(Long cId);

    // Add more custom query methods if needed based on your requirements
	
	 Cart findByCustomer_Id(Long customerId);

}
