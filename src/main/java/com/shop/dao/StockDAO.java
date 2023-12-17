package com.shop.dao;

import com.shop.entity.Stock;

import jakarta.validation.Valid;

import java.util.Optional;

public interface StockDAO {
    
    // Creates a new stock entry for a specific product with validation
    Stock createStock(Long productId, @Valid Stock stock);
    
    // Retrieves the stock information for a specific product
    Optional<Stock> getStockByProductId(Long productId);
    
    // Updates the stock information for a specific product with validation
    Stock updateStock(Long productId, @Valid Stock updatedStock);
    
    // Deletes the stock entry for a specific product
    void deleteStock(Long productId);
}
