package com.shop.dao;

import com.shop.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    
    // Creates a new customer
    Customer createCustomer(Customer customer);
    
    // Retrieves a list of all customers
    List<Customer> getAllCustomers();
    
    // Retrieves a customer by their unique identifier
    Optional<Customer> getCustomerById(Long id);
    
    // Updates the information of an existing customer
    Customer updateCustomer(Long id, Customer updatedCustomer);
}
