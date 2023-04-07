package com.example.pointofsale.controller;

import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.Model.StockModel;
import com.example.pointofsale.service.ProductService;
import com.example.pointofsale.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<StockModel> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockModel> getStockById(@PathVariable Long id) {
        StockModel stockModel = stockService.getStockById(id);
        if (stockModel != null) {
            return new ResponseEntity<>(stockModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<StockModel> createStock(@RequestBody StockModel stockModel) {
        StockModel createdStock = stockService.createStock(stockModel);
        if (createdStock != null) {
            return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockModel> updateStock(@PathVariable Long id, @RequestBody StockModel stockModel) {
        StockModel updatedStock = stockService.updateStock(id, stockModel);
        if (updatedStock != null) {
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStock(@PathVariable Long id) {
        boolean success = stockService.deleteStock(id);
        if (success) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

