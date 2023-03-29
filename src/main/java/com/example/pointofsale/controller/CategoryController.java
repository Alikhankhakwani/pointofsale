package com.example.pointofsale.controller;

import com.example.pointofsale.Model.CategoryModel;
import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    public CategoryService categoryService;


    @GetMapping(path = "/listCategory" )
    public List<CategoryModel> getProducts()
    {
        return categoryService.findCategory();
    }


    @PostMapping("/saveCategory")
    public String addCategory(@RequestBody CategoryModel categoryModel) {
        return categoryService.save(categoryModel);
    }
    @DeleteMapping("/deleteCategory/{id}")
    public String delete(@PathVariable("id") Long productId) {
        categoryService.deleteCategory(productId);
        return "Product Deleted Successfully ";
    }
}

