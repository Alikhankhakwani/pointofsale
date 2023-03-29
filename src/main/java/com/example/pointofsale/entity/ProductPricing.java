package com.example.pointofsale.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_pricing")

public class ProductPricing implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pricing_Id")
    private Pricing pricing;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;


}
