package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class ProductModel {


    private long productId;
    private String productName;
    private double productBuyingPrice;
    private double productSellingPrice;

    private CategoryModel categoryModel;

    public ProductModel(Product product) {
        this.productId=product.getProductId();
        this.productName=product.getProductName();
        this.productBuyingPrice=product.getProductBuyingPrice();
        this.productSellingPrice=product.getProductSellingPrice();
        this.categoryModel = new CategoryModel(product.getCategory());


    }


    public Product disassemble() {
        Product product = new Product();
        CategoryModel categoryModel1 = new CategoryModel();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductBuyingPrice(productBuyingPrice);
        product.setProductSellingPrice(productSellingPrice);
        product.setCategory(categoryModel1.disassemble());

        return product;

    }

    public ProductModel assemble(Product product) {
        ProductModel productModel = new ProductModel();
        CategoryModel newCategoryModel = new CategoryModel();

        productModel.setProductId(product.getProductId());
        productModel.setProductName(product.getProductName());
        productModel.setProductBuyingPrice(product.getProductBuyingPrice());
        productModel.setProductSellingPrice(product.getProductSellingPrice());
        productModel.setCategoryModel(categoryModel.assemble(product.getCategory()));
        return productModel;

    }





}
