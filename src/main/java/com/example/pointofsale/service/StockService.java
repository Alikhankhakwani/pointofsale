package com.example.pointofsale.service;

import com.example.pointofsale.Model.StockModel;
import com.example.pointofsale.entity.Stock;
import com.example.pointofsale.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<StockModel> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream()
                .map(StockModel::new)
                .collect(Collectors.toList());
    }

    public StockModel getStockById(Long id) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if (stock != null) {
            return new StockModel(stock);
        }
        return null;
    }

    public StockModel createStock(StockModel stockModel) {
        Stock stock = stockModel.disassemble();
        stock = stockRepository.save(stock);
        return new StockModel(stock);
    }

    public StockModel updateStock(Long id, StockModel stockModel) {
        Stock existingStock = stockRepository.findById(id).orElse(null);
        if (existingStock != null) {
            Stock updatedStock = stockModel.disassemble();
            updatedStock.setId(id);
            updatedStock = stockRepository.save(updatedStock);
            return new StockModel(updatedStock);
        }
        return null;
    }

    public boolean deleteStock(Long id) {
        stockRepository.deleteById(id);
        return false;
    }

}
