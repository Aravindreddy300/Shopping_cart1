package com.shop.service;

import com.shop.dao.StockDAO;
import com.shop.entity.Product;
import com.shop.entity.Stock;
import com.shop.repository.ProductRepository;
import com.shop.repository.StockRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class StockService implements StockDAO {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    @Autowired
    public StockService(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    public Stock createStock(Long productId, @Valid Stock stock) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
           // stock.setProduct(product);
            return stockRepository.save(stock);
        } else {
            throw new IllegalArgumentException("Product with ID " + productId + " not found.");
        }
    }

    public Optional<Stock> getStockByProductId(Long productId) {
        return stockRepository.findById(productId);
    }

    public Stock updateStock(Long productId, @Valid Stock updatedStock) {
        Stock existingStock = getStockByProductId(productId).get();

        if (existingStock != null) {
            existingStock.setQuantity(updatedStock.getQuantity());
            existingStock.setLocation(updatedStock.getLocation());
            existingStock.setSupplier(updatedStock.getSupplier());
            return stockRepository.save(existingStock);
        } else {
            return null;
        }
    }

    public void deleteStock(Long productId) {
        stockRepository.deleteById(productId);
    }
}
