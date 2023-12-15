package com.shop.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.OrderDAO;
import com.shop.entity.Cart;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.entity.Stock;
import com.shop.repository.CartRepository;
import com.shop.repository.CustomerRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.repository.StockRepository;
@Service
public class OrderService implements OrderDAO{

	
	@Autowired 
	CartService cartService;
	@Autowired
	OrderRepository orderRepository;
	
//	private final OrderRepository orderRepository;
//
//    @Autowired
//    public OrderService(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
    
	@Autowired
	CustomerRepository customerRepository; 
	
	@Autowired
	StockRepository stockRepository; 
	
	

	
	/*
	public Order createOrder(Long cId, Long pId) {
		Order order=new Order();
		//order.setcId(cId);
		//order.setpId(pId);
		//to do
		order.setoCost(400.8);
		order.setoDate(LocalDate.now());
		return orderRepository.save(order); 
	}*/
	
	
	
	

	public List<Order> getOrdersByCustomerId(Long cId) {
	
		return orderRepository.findAll();
	}




	



	public Order createOrder(Long cId) {
		Order order=new Order();
		Cart cart=cartService.getCartByCustomerId(cId);
		System.out.println(cart);
		
		order.setCart(cart);
		order.setoDate(LocalDate.now());
		Double cost=0.0;
		//Double cost=cart.getQuantity()*cart.getProducts().getPrice();
		List<Product> prod=cart.getProducts();
		
		for(Product p : prod) {
			cost=cost+(cart.getQuantity()*p.getPrice());
		}
		
		order.setoCost(cost);

		return orderRepository.save(order);
	}

}
