package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name="product_invoice")
@NamedQuery(name="ProductInvoice.findAll", query="SELECT p FROM ProductInvoice p")
public class ProductInvoice implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int refId;

    //bi-directional many-to-one association to Invoice
    @ManyToOne
    @JoinColumn(name="invoices_id")
    private Invoice invoice;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="products_id")
    private Product product;

    public ProductInvoice() {
    }
}
