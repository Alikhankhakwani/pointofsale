package com.example.pointofsale.entity;

import com.example.pointofsale.entity.product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name = "supplier")
public class supplier  {

    @Id
    private String productid;
    private String productname;
    private String productquantity;
}
