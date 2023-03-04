package com.example.pointofsale.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="supplier_log")
@NamedQuery(name="SupplierLog.findAll", query="SELECT s FROM SupplierLogEntity s")
public class SupplierLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    public SupplierLogEntity() {
    }
}
