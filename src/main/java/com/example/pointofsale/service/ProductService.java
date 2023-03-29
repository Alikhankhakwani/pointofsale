package com.example.pointofsale.service;

import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.entity.Product;
import com.example.pointofsale.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;


    public String save(ProductModel productModel) {
        if (!productRepository.existsById(productModel.getProductId())) {
            productModel.assemble(productRepository.save(productModel.disassemble()));
            return "Product Saved Successfully ";
        }

        else

        {
            return "Product Already Exists";
        }
    }



    public String deleteProduct(Long id ) {
        productRepository.deleteById(id);
        return "Product Deleted Successfully ";
    }

    public List<ProductModel> findProduct() {

        List<ProductModel> productModels = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            ProductModel productModel = new ProductModel(product);
            productModels.add(productModel);

        }
        return productModels;
    }



    public List<ProductModel> getProducts(Long productId, String productName) {
        List<ProductModel> products = new ArrayList<>();
        if (productId != null) {
            products = List.of(productRepository.findAll()
                    .stream()
                    .map(ProductModel::new)
                    .filter(productModel -> productModel.getProductId() == (productId))
                    .findFirst()
                    .get());

        } else if (productName != null) {
            products = List.of(productRepository.findAll()
                    .stream()
                    .map(ProductModel::new)
                    .filter(productModel -> productModel.getProductName().equalsIgnoreCase(productName))
                    .findFirst()
                    .get());

        } else {
            products = productRepository.findAll()
                    .stream()
                    .map(ProductModel::new)
                    .collect(Collectors.toList());
        }
        return products;
    }
}
















