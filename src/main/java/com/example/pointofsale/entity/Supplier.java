package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity

public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int supplierId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private String createdUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    private String lastModifiedUser;

    private String supplierCompany;

    private BigDecimal supplierContact;

    private String supplierName;

    private BigDecimal version;


    @OneToMany(mappedBy="supplier")
    private List<Stock> stocks;

    public Supplier() {
    }
}
