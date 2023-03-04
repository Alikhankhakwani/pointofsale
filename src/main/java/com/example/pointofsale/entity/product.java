package com.example.pointofsale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "product")
public class product {
    @Id
    private String productid;
    @Column
    private String productname;
    @Column
    private String productquantity;

}
