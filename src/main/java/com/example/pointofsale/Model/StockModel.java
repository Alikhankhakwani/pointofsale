package com.example.pointofsale.Model;
import com.example.pointofsale.entity.Stock;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class StockModel {
    private long Id;
    private Date dateStock;
    private long quantity;
    private CategoryModel categoryModel;
    private ProductModel productModel;
//    private SupplierModel supplierModel;


    public StockModel(Stock stock) {
        this.Id=stock.getId();
       this.dateStock=stock.getDateStock();
       this.quantity=stock.getQuantity();
//        this.categoryModel = new CategoryModel(stock.getCategory());
//        this.productModel = new ProductModel(stock.getProduct());
//        this.supplierModel=new SupplierModel(stock.getSupplier());

    }



    public Stock disassemble() {
        Stock stock = new Stock();
        CategoryModel categoryModel1 = new CategoryModel();
//        ProductModel productModel1 = new ProductModel(productInvoice.getProduct());
//        SupplierModel supplierModel1 = new SupplierModel();
        stock.setId(Id);
        stock.setDateStock(dateStock);
        stock.setQuantity(quantity);
        stock.setCategory(categoryModel1.disassemble());
//        stock.setSupplier(supplierModel1.disassemble());

        return stock;

    }

    public StockModel assemble(Stock stock) {
        StockModel stockModel = new StockModel();
//        ProductModel newProductModel = new  ProductModel(productInvoice.getProduct());
//        SupplierModel newSupplierModel = new SupplierModel();

        stockModel.setId(stock.getId());
        stockModel.setDateStock(stock.getDateStock());
        stockModel.setQuantity(stock.getQuantity());
//        stockModel.setCategoryModel(categoryModel.assemble(stock.getCategory()));
//        stockModel.setProductModel(productModel.assemble(stock.getProduct()));
//        stockModel.setSupplierModel(supplierModel.assemble(stock.getSupplier()));
        return stockModel;

    }
}
