package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int invoiceId;

    private double lineTotal;

    private int productId;

    private String productName;

    private double quantity;

    private double total;

    private BigDecimal version;

    //bi-directional many-to-one association to ProductInvoice
    @OneToMany(mappedBy="invoice")
    private List<ProductInvoice> productInvoices;

    public Invoice() {
    }
}
