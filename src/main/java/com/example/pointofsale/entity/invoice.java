package com.example.pointofsale.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "invoice")

public class invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productid;
    private String productname;
    private String productquantity;
}
