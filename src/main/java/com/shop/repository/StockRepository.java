package com.shop.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}