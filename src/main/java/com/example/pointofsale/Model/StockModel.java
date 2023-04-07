package com.example.pointofsale.Model;
import com.example.pointofsale.entity.Product;
import com.example.pointofsale.entity.Stock;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include. NON_NULL)
public class StockModel {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long quantity;
    private CategoryModel categoryModel;
    private ProductModel productModel;
    private SupplierModel supplierModel;


    public StockModel(Stock stock) {

            this.setId(stock.getId());
            this.setDate(stock.getDate());
            this.setQuantity(stock.getQuantity());
//            this.categoryModel=new CategoryModel();
//            this.productModel=new ProductModel();
//            this.supplierModel=new SupplierModel();
            this.setCategoryModel(new CategoryModel().assemble(stock.getCategory()));
            this.setProductModel(new ProductModel().assemble(stock.getProduct()));
            this.setSupplierModel(new SupplierModel().assemble(stock.getSupplier()));
    }
           public StockModel() {
           this.id=getId();
           this.date=getDate();
           this.quantity=getQuantity();
           this.categoryModel=new CategoryModel();
           this.productModel=new ProductModel();
           this.supplierModel=new SupplierModel();

    }


    public Stock disassemble() {
        Stock stock = new Stock();
              stock.setId(id);
              stock.setDate(date);
              stock.setQuantity(quantity);
              stock.setCategory(categoryModel.disassemble());
              stock.setProduct(productModel.disassemble());
              stock.setSupplier(supplierModel.disassemble());

        return stock;

    }

         public StockModel assemble(Stock stock) {
          StockModel stockModel = new StockModel();
          stockModel.setId(stock.getId());
          stockModel.setDate(stock.getDate());
          stockModel.setQuantity(stock.getQuantity());
          stockModel.setCategoryModel(new CategoryModel().assemble(stock.getCategory()));
          stockModel.setProductModel(new ProductModel().assemble(stock.getProduct()));
          stockModel.setSupplierModel(new SupplierModel().assemble(stock.getSupplier()));
          return stockModel;

    }
}
