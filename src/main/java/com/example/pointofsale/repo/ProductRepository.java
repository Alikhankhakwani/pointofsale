package com.example.pointofsale.repo;

import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.entity.Category;
import com.example.pointofsale.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<ProductModel> findProductsByCategoryId(Long categoryId);

    List<Product> findByCategoryId(Long categoryId);

}
