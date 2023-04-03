package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class CategoryModel {


    private Long id;

    private String Name;


    public Category disassemble() {
        Category category = new Category(id);
        category.setId(id);
        category.setName(Name);



        return category;
    }
    public CategoryModel assemble(Category Category){
        CategoryModel categoryModel=new CategoryModel();
        categoryModel.setId(Category.getId());
        categoryModel.setName(Category.getName());

        return categoryModel;
    }
    }
