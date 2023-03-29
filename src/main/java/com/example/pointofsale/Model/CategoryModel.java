package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class CategoryModel {


    private long categoryId;

    private String categoryName;

    public CategoryModel(Category category) {
        this.categoryId=getCategoryId();
        this.categoryName=getCategoryName();
    }

    public Category disassemble() {
        Category category = new Category();

        category.setCategoryId(categoryId);
        category.setCategoryName(categoryName);
        return category;
    }


        public CategoryModel assemble (Category category){
            CategoryModel categoryModel = new CategoryModel();

            categoryModel.setCategoryId(category.getCategoryId());
            categoryModel.setCategoryName(category.getCategoryName());

            return categoryModel;


        }
    }
