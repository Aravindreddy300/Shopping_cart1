package com.shop.service;

import com.shop.dao.ProductDAO;
import com.shop.entity.Product;
import com.shop.repository.ProductRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(@Valid Product product) {
        // Additional validation or business logic can be added here
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
    	if(productRepository.findById(id)!=null) {
        return productRepository.findById(id).get();
    	}else {
    		return null;
    	}
    }

    public Product updateProduct(Long id, @Valid Product updatedProduct) {
        // Additional validation or business logic can be added here
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setCategory(updatedProduct.getCategory());
                    existingProduct.setStock(updatedProduct.getStock());
                   // existingProduct.setCart(updatedProduct.getCart());
                    return productRepository.save(existingProduct);
                })
                .orElse(null); // Handle the case where the product with the given id is not found
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
