package com.shop.controller;

import com.shop.entity.Stock;
import com.shop.exception.CustomerNotFoundException;
import com.shop.exception.StockNotFoundException;
import com.shop.service.StockService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

   /* @PostMapping("/{productId}")
    public ResponseEntity<Stock> createStock(@PathVariable Long productId, @Validated @RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.createStock(productId, stock), HttpStatus.CREATED);
    }*/

  @GetMapping("/{productId}")
    public ResponseEntity<Stock> getStockByProductId(@PathVariable Long productId) {
        Optional<Stock> stock = stockService.getStockByProductId(productId);
        
        stock.orElseThrow(()-> new StockNotFoundException("stock not found "+productId));
        
        
        
        return stock.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long productId, @Validated @RequestBody Stock updatedStock) {
        Stock result = stockService.updateStock(productId, updatedStock);
        return result != null ?
                new ResponseEntity<>(result, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long productId) {
        stockService.deleteStock(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
