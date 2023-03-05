package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private int productId;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Column
    private String createdUser;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;
    @Column
    private String lastModifiedUser;
    @Column
    private double productbuyingPrice;
    @Column
    private byte productIsService;
    @Column
    private String productName;
    @Column
    private double productsellingPrice;
    @Column
    private BigDecimal version;


    @ManyToOne
    @JoinColumn(name="category_Id")
    private Category category;


    @OneToMany(mappedBy="product")
    private List<ProductInvoice> productInvoices;


    @OneToMany(mappedBy="product")
    private List<ProductPricing> productPricings;


    @OneToMany(mappedBy="product")
    private List<Stock> stocks;
}
