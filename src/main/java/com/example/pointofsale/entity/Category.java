package com.example.pointofsale.entity;

import com.example.pointofsale.Model.CategoryModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId;
;
    @Column(name = "category_Name")
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    @OneToMany(mappedBy="category")
    private List<Stock> stocks;



}