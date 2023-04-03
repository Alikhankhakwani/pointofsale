package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Invoice;
import com.example.pointofsale.entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductModel {

    private Long id;
    private String name;
    private Double price;
    private CategoryModel categoryModel;

    public ProductModel(Product product){
        this.setId(product.getId());
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.categoryModel=new CategoryModel();
        this.setCategoryModel(new CategoryModel().assemble(product.getCategory()));
    }

    public ProductModel() {
        this.id=getId();
        this.name=getName();
        this.price=getPrice();
        this.categoryModel=new CategoryModel();


    }

    public ProductModel(Object o) {
    }


    public  Product disassemble() {
        Product product = new  Product();

        product.setId(id);
        product.setName(name);
        product.setPrice(price != null ? price.doubleValue() : null);
        product.setCategory((categoryModel.disassemble()));
        return product;
    }
    public ProductModel assemble(Product product) {
        ProductModel productModel = new ProductModel(product);
        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setPrice(product.getPrice());
        productModel.setCategoryModel(new CategoryModel().assemble(product.getCategory()));
        return productModel;
    }
}








