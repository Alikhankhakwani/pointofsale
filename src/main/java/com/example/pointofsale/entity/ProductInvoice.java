package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name="product_invoice")

public class ProductInvoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ref_Id")
    private int refId;


    @ManyToOne
    @JoinColumn(name="invoices_id")
    private Invoice invoice;


    @ManyToOne
    @JoinColumn(name="products_id")
    private Product product;

    public ProductInvoice() {
    }
}
