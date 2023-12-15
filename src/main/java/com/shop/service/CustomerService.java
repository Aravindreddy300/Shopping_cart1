package com.shop.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.CustomerDAO;
import com.shop.entity.Customer;
import com.shop.repository.CustomerRepository;

import jakarta.validation.Valid;

@Service
public class CustomerService implements  CustomerDAO{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(@Valid Customer customer) {
        // Additional validation or business logic can be added here
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    
    

    public Customer updateCustomer(Long id, @Valid Customer updatedCustomer) {
        // Additional validation or business logic can be added here
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setName(updatedCustomer.getName());
                    existingCustomer.setAddress(updatedCustomer.getAddress());
                    existingCustomer.setContact(updatedCustomer.getContact());
                   // existingCustomer.setProducts(updatedCustomer.getProducts());
                    return customerRepository.save(existingCustomer);
                })
                .orElse(null); // Handle the case where the customer with the given id is not found
    }
}

