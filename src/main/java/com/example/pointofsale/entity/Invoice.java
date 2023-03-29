package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "invoice_Id")
    private long invoiceId;
    @Column(name = "category_Name")
    private String categoryName;
    @Column(name = "product_id")
    private long productId;
    @Column(name = "product_Name")
    private String productName;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy="invoice")
    private List<ProductInvoice> productInvoices;


}
