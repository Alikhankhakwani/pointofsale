package com.example.pointofsale.controller;

import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.Model.StockModel;
import com.example.pointofsale.service.ProductService;
import com.example.pointofsale.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

        @Autowired
        public StockService stockService;


        @GetMapping(path = "/listStock" )
        public List<StockModel> getProducts()
        {
            return stockService.findStock();
        }

        @GetMapping("/Stock/{id}" )
        public List<StockModel> getStocks(@PathVariable("id") Long productId)
        {
            return stockService.getStocks(productId,null);
        }
        @PostMapping("/saveStock")
        public String addStock(@RequestBody StockModel stockModel) {
            return   stockService.save(stockModel);

        }


        @DeleteMapping("/deleteStock/{id}")
        public String delete(@PathVariable("id") Long productId) {
            stockService.deleteProduct(productId);
            return "Stock Deleted Successfully ";
        }



    }

