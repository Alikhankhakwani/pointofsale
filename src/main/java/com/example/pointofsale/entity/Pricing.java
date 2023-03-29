package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pricing implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private long pricingId;
    @Column(name = "pricing_Amount")
    private String pricingAmount;




    @OneToMany(mappedBy="pricing")
    private List<ProductPricing> productPricing;


}
