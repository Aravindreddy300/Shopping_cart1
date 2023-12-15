package com.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CartDAO;
import com.shop.entity.Cart;
import com.shop.entity.Customer;
import com.shop.entity.Product;
import com.shop.repository.CartRepository;
import com.shop.repository.CustomerRepository;
import com.shop.repository.ProductRepository;

@Service
public class CartService implements CartDAO {

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	@Autowired
	CartRepository cartRepository;

//	public Cart addToCart(Long productId, Long customerId,int quantity) {
//		
//		Customer c=customerService.getCustomerById(productId).get();
//		Product p=productService.getProductById(productId).get();
//		Cart cart=new Cart();
//		cart.setCustomer(c);
//		cart.setProduct(p);
//		cart.setQuantity(quantity);
//		
//		
//		return cartRepository.save(cart);
//	}

//	public Cart addToCart(Long productId, Long customerId, int quantity) {
//		
//        // Find the product by ID
//		Cart cart = cartRepository.findByCustomer_Id(customerId);
//		Customer c=customerService.getCustomerById(productId).get();
//		if(cart==null) {
//			cart = new Cart();
//			List<Product> prod=new ArrayList<>();
//			prod.add(productService.getProductById(productId));
//			cart.setCustomer(c);
//            cart.setProducts(prod);
//		}else {
//			List<Product> prod=cart.getProducts();
//			prod.add(productService.getProductById(productId));
//			cart.setCustomer(c);
//			cart.setProducts(prod);
//		}
//		return cartRepository.save(cart);
//	}
	
	public Cart addToCart(Long productId, Long customerId, int quantity) {
	    // Find the customer by ID
	    Optional<Customer> customerOptional = customerService.getCustomerById(customerId);
	    
	    if (customerOptional.isPresent()) {
	        Customer customer = customerOptional.get();
	        
	        // Find the product by ID
	        Product product = productService.getProductById(productId);
	        
	        // Find the cart by customer ID
	        Cart cart = cartRepository.findByCustomer_Id(customerId);
	        
	        if (cart == null) {
	            // If the cart doesn't exist, create a new one
	            cart = new Cart();
	            cart.setCustomer(customer);
	            List<Product> products = new ArrayList<>();
	            products.add(product);
	            cart.setProducts(products);
	        } else {
	            // If the cart exists, add the product to it
	            List<Product> products = cart.getProducts();
	            products.add(product);
	            cart.setCustomer(customer);
	            cart.setProducts(products);
	        }
	        
	        // Save the cart
	        return cartRepository.save(cart);
	    } else {
	        // Handle the case where the customer is not found
	        // You may throw an exception or return a special value indicating an error
	        return null; // For simplicity, returning null here; consider better error handling
	    }
	}

	public List<Cart> getCart() {

		return cartRepository.findAll();

	}

	public Cart getCartByCustomerId(Long customerId) {
		// Assuming CartRepository has a method like findByCustomer_Id
		// return cartRepository.findByCustomer_Id(customerId);
		return cartRepository.findByCustomer_Id(customerId);

	}

}
