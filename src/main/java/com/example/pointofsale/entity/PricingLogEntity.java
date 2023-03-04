package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table(name="pricing_log")
@NamedQuery(name="PricingLog.findAll", query="SELECT p FROM PricingLogEntity p")
public class PricingLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int pricingId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private String createdUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    private String lastModifiedUser;

    private BigDecimal pricingDiscountPrecentage;

    @Temporal(TemporalType.DATE)
    private Date pricingEffectiveDate;

    @Temporal(TemporalType.DATE)
    private Date pricingExpireDate;

    private String pricingName;

    private BigDecimal version;

    public PricingLogEntity() {
    }
}
