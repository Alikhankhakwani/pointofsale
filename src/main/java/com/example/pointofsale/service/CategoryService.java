package com.example.pointofsale.service;

import com.example.pointofsale.Model.CategoryModel;
import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.entity.Category;
import com.example.pointofsale.entity.Product;
import com.example.pointofsale.repo.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public String save(CategoryModel categoryModel) {
        if (!categoryRepository.existsById(categoryModel.getCategoryId())) {
            categoryModel.assemble(categoryRepository.save(categoryModel.disassemble()));
            return "CategorySaved Successfully ";
        }

        else

        {
            return "CategoryAlready Exists";
        }
    }
    public String deleteCategory(Long id ) {
        categoryRepository.deleteById(id);
        return "Category Deleted Successfully ";
    }
    public List<CategoryModel> findCategory() {

        List<CategoryModel> categoryModels = new ArrayList<>();
        List<Category> categorys = categoryRepository.findAll();
        for (Category category : categorys) {
            CategoryModel categoryModel = new CategoryModel(category);
            categoryModels.add(categoryModel);

        }
        return categoryModels;
    }

}

