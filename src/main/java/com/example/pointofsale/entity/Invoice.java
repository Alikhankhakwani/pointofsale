package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "invoice_Id")
    private int invoiceId;
    @Column(name = "lineTotal")
    private double lineTotal;
    @Column(name = "category_Id")
    private int productId;
    @Column(name = "category_Id")
    private String productName;
    @Column(name = "category_Id")
    private double quantity;
    @Column(name = "category_Id")
    private double total;
    @Column(name = "category_Id")
    private BigDecimal version;


    @OneToMany(mappedBy="invoice")
    private List<ProductInvoice> productInvoices;

    public Invoice() {
    }
}
