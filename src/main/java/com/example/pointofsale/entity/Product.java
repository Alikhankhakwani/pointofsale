package com.example.pointofsale.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private long productId;
    @Column(name = "product_Name")
    private String productName;

    @Column(name = "product_BuyingPrice")
    private double productBuyingPrice;

    @Column(name = "product_SellingPrice")
    private double productSellingPrice;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="category_Id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy="product")
    private List<ProductInvoice> productInvoices;
    @JsonIgnore
    @OneToMany(mappedBy="product")
    private List<ProductPricing> productPricing;

    @JsonIgnore
    @OneToMany(mappedBy="product")
    private List<Stock> stocks;



}
