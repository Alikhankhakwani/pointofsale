package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@Entity

public class Pricing implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private int pricingId;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Column
    private String createdUser;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;
    @Column
    private String lastModifiedUser;

    @Column
    @Temporal(TemporalType.DATE)
    private Date pricingEffectiveDate;
    @Column
    @Temporal(TemporalType.DATE)
    private Date pricingExpireDate;
    @Column
    private String pricingName;
    @Column
    private BigDecimal version;


    @OneToMany(mappedBy="pricing")
    private List<ProductPricing> productPricings;

    public Pricing() {
    }
}
