package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
@Entity
@Table(name="product_pricing")

public class ProductPricing implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int refId;


    @ManyToOne
    @JoinColumn(name="pricing_Id")
    private Pricing pricing;


    @ManyToOne
    @JoinColumn(name="product_Id")
    private Product product;

    public ProductPricing() {
    }
}
