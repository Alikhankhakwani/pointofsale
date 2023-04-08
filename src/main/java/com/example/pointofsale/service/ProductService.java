package com.example.pointofsale.service;

import com.example.pointofsale.Model.CategoryModel;
import com.example.pointofsale.Model.ProductModel;

import com.example.pointofsale.entity.Category;
import com.example.pointofsale.entity.Product;
import com.example.pointofsale.repo.CategoryRepository;
import com.example.pointofsale.repo.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    @NonNull
    private ProductRepository productRepository;

    @NonNull
    private CategoryRepository categoryRepository;

    public ProductModel getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return new ProductModel().assemble(optionalProduct.get());
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    public List<ProductModel> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> new ProductModel().assemble(product)).collect(Collectors.toList());
    }

    public ProductModel createProduct(ProductModel productModel) {
        Product product = new Product();
        product.setName(productModel.getName());
        product.setPrice(productModel.getPrice());
        Category category = categoryRepository.findById(productModel.getCategoryModel().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + productModel.getCategoryModel().getId()));
        product.setCategory(category);
        productRepository.save(product);
        return new ProductModel().assemble(product);
    }

    public ProductModel updateProduct(Long id, ProductModel productModel) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productModel.getName());
            product.setPrice(productModel.getPrice());
            Category category = categoryRepository.findById(productModel.getCategoryModel().getId())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + productModel.getCategoryModel().getId()));
            product.setCategory(category);
            productRepository.save(product);
            return new ProductModel().assemble(product);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.delete(optionalProduct.get());
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }
}


















