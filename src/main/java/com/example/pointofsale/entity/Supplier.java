package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "stock_Id")
    private long Id;
    @Column(name = "supplier_Name")
    private String supplierName;
    @Column(name = "supplier_Company")
    private String supplierCompany;
    @Column(name = "supplier_Contact")
    private BigDecimal supplierContact;





    @OneToMany(mappedBy="supplier")
    private List<Stock> stocks;


}
