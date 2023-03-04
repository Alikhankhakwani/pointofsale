package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
@Entity
@Table(name="product_pricing")
@NamedQuery(name="ProductPricing.findAll", query="SELECT p FROM ProductPricing p")
public class ProductPricing implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int refId;

    //bi-directional many-to-one association to Pricing
    @ManyToOne
    @JoinColumn(name="pricing_Id")
    private Pricing pricing;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="product_Id")
    private Product product;

    public ProductPricing() {
    }
}
