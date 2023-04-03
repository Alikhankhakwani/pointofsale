package com.example.pointofsale.repo;

import com.example.pointofsale.Model.CategoryModel;
import com.example.pointofsale.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String Name);
}
