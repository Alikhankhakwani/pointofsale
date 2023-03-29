package com.example.pointofsale.service;

import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.Model.StockModel;
import com.example.pointofsale.entity.Product;
import com.example.pointofsale.entity.Stock;
import com.example.pointofsale.repo.ProductRepository;
import com.example.pointofsale.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    public StockRepository stockRepository;


    public String save(StockModel stockModel) {
        if (!stockRepository.existsById(stockModel.getId())) {
            stockModel.assemble(stockRepository.save(stockModel.disassemble()));
            return "Stock Saved Successfully ";
        }

        else

        {
            return "Stock Already Exists";
        }
    }



    public String deleteProduct(Long id ) {
        stockRepository.deleteById(id);
        return "Stock Deleted Successfully ";
    }

    public List<StockModel> findStock() {

        List<StockModel> stockModels = new ArrayList<>();
        List<Stock> stocks = stockRepository.findAll();
        for (Stock stock : stocks) {
            StockModel stockModel = new StockModel(stock);
            stockModels.add(stockModel);

        }
        return stockModels;
    }



    public List<StockModel> getStocks(Long Id, String stockName) {
        List<StockModel> stocks = new ArrayList<>();
        if (Id != null) {
            stocks = List.of(stockRepository.findAll()
                    .stream()
                    .map(StockModel::new)
                    .filter(stockModel -> stockModel.getId() == (Id))
                    .findFirst()
                    .get());

        }
         else {
            stocks = stockRepository.findAll()
                    .stream()
                    .map(StockModel::new)
                    .collect(Collectors.toList());
        }
        return stocks;
    }
}
