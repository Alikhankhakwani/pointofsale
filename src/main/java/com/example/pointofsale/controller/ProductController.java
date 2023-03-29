package com.example.pointofsale.controller;

import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    public class ProductController {
    @Autowired
    public ProductService productService;


    @GetMapping(path = "/listProduct" )
    public List<ProductModel> getProducts()
    {
        return productService.findProduct();
    }

    @GetMapping("/product/{id}" )
    public List<ProductModel> getProducts(@PathVariable("id") Long productId)
    {
        return productService.getProducts(productId,null);
    }
    @PostMapping("/saveProduct")
    public String addProduct(@RequestBody ProductModel productModel) {
       return   productService.save(productModel);

    }


    @DeleteMapping("/deleteProduct/{id}")
    public String delete(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return "Product Deleted Successfully ";
    }



    }




