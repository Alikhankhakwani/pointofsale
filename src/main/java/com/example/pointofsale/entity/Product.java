package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int productId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private String createdUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    private String lastModifiedUser;

    private double productbuyingPrice;

    private byte productIsService;

    private String productName;

    private double productsellingPrice;

    private BigDecimal version;

    //bi-directional many-to-one association to Category
    @ManyToOne
    @JoinColumn(name="category_Id")
    private Category category;

    //bi-directional many-to-one association to ProductInvoice
    @OneToMany(mappedBy="product")
    private List<ProductInvoice> productInvoices;

    //bi-directional many-to-one association to ProductPricing
    @OneToMany(mappedBy="product")
    private List<ProductPricing> productPricings;

    //bi-directional many-to-one association to Stock
    @OneToMany(mappedBy="product")
    private List<Stock> stocks;
}
