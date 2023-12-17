package com.shop.dao;

import com.shop.entity.Product;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {
    
    // Creates a new product with validation
    Product createProduct(@Valid Product product);
    
    // Retrieves a list of all products
    List<Product> getAllProducts();
    
    // Updates the information of an existing product with validation
    Product updateProduct(Long id, @Valid Product updatedProduct);
    
    // Deletes a product by its unique identifier
    void deleteProduct(Long id);
}
