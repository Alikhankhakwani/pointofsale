package com.example.pointofsale.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "sale")
public class sale  {

    @Id
    private String productid;
    private String productname;
    private String productquantity;
}
