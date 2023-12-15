package com.shop.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Customer;
import com.shop.entity.Employee;
import com.shop.entity.Order;
import com.shop.entity.Product;
import com.shop.entity.Stock;
import com.shop.repository.OrderRepository;
import com.shop.repository.ProductRepository;
import com.shop.repository.StockRepository;
import com.shop.service.CartService;
import com.shop.service.CustomerService;
import com.shop.service.EmployeeService;
import com.shop.service.ProductService;

@RestController
@RequestMapping("/")
public class ReportController {
	@Autowired
	CustomerService customerService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	StockRepository stockService;

	@Autowired
	CartService cartService;

	@Autowired
	OrderRepository orderService;
	
	@Autowired
	ProductService productService;

	// Customer
	@GetMapping("/sortedcustomers")
	public List<Customer> getAllSortedCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		List<Customer> sortedByName = customers.stream().sorted(Comparator.comparing(Customer::getName))
				.collect(Collectors.toList());

		return sortedByName;
	}
	
	
	//Stock
	@GetMapping("/sortedStock")
	public List<Stock> getAllSortedStocks() {
		List<Stock> stocks = stockService.findAll();
		List<Stock> filteredStocks = stocks.stream().filter(stock -> stock.getQuantity() > 10) // Filter stocks where
																								// quantity is greater
																								// than 10
				.collect(Collectors.toList());
		return filteredStocks;
	}
	
	//Orders

	@GetMapping("/latest/{count}")
	public ResponseEntity<List<Order>> getLatestOrders(@PathVariable int count) {
		List<Order> orders = orderService.findAll().stream().sorted(Comparator.comparing(Order::getoDate).reversed())
				.limit(count).collect(Collectors.toList());
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	//cart

	@GetMapping("/exists/{productId}")
	public boolean doesProductExistInCart(@PathVariable Long productId) {

		return cartService.getCart().stream().anyMatch(cart -> cart.getProducts().equals(productId));
	}

	// Employees
	@GetMapping("/sortedEmployees")
	public List<Employee> getAllSortedEmployees() {
		List<Employee> employee = employeeService.getAllEmployees();
		List<Employee> sortedByName = employee.stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());

		return sortedByName;
	}
	
	//products
	
	@GetMapping("/group-by-category")
	public Map<String, List<Product>> groupProductsByCategory() {
	    Map<String, List<Product>> groupedProducts = productService.getAllProducts().stream()
	            .collect(Collectors.groupingBy(Product::getCategory));
	    return groupedProducts;
	}


}