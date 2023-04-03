package com.example.pointofsale.service;

import com.example.pointofsale.Model.CategoryModel;
import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.entity.Category;
import com.example.pointofsale.entity.Product;
import com.example.pointofsale.repo.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;


import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public String save(CategoryModel categoryModel) {
        if (!categoryRepository.existsById(categoryModel.getId())
                && categoryRepository.findByName(categoryModel.getName()) == null) {
            categoryModel.assemble(categoryRepository.save(categoryModel.disassemble()));
            return "Category saved successfully.";
        } else {
            return "Category already exists.";
        }
    }
    public CategoryModel update(Long id, CategoryModel categoryModel) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        Category updatedCategory = categoryModel.disassemble();
        updatedCategory.setId(existingCategory.getId());
        updatedCategory = categoryRepository.save(updatedCategory);
        return categoryModel.assemble(updatedCategory);
    }

    public String deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return "Category Deleted Successfully";
        } else {
            return "Category Not Found";
        }
    }

    public List<CategoryModel> findCategory() {
        List<Category> airLineFlights = categoryRepository.findAll();
        return airLineFlights.stream().map(airLineFlight -> new CategoryModel().assemble(airLineFlight)).collect(Collectors.toList());
    }

    }


