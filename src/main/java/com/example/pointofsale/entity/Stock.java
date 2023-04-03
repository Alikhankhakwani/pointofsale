package com.example.pointofsale.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;


    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Column(name = "quantity")
    private Long quantity;

    //private int stockId;

    @ManyToOne
    @JoinColumn(name="category_Id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="product_Id")
    private Product product;


    @ManyToOne
    @JoinColumn(name="supplier_Id")
    private Supplier supplier;




}
