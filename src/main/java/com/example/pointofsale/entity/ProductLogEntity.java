package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table(name="product_log")
@NamedQuery(name="ProductLog.findAll", query="SELECT p FROM ProductLogEntity p")
public class ProductLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int productId;

    private int categoryId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private String createdUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    private String lastModifiedUser;

    private int pricingId;

    private double productbuyingPrice;

    private byte productIsService;

    private String productName;

    private double productSellingPrice;

    private BigDecimal version;

    public ProductLogEntity() {
    }
}
