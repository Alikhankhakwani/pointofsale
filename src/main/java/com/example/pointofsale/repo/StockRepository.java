package com.example.pointofsale.repo;

import com.example.pointofsale.entity.Product;
import com.example.pointofsale.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
