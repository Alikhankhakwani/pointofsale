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
@Table(name="product_invoice")
@AllArgsConstructor
@NoArgsConstructor

public class ProductInvoice implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

 @JsonIgnore
    @ManyToOne
    @JoinColumn(name="invoices_id")
    private Invoice invoice;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="products_id")
    private Product product;


}
