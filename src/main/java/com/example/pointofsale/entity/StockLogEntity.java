package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table(name="stock_log")
@NamedQuery(name="StockLog.findAll", query="SELECT s FROM StockLogEntity s")
public class StockLogEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int refId;

    private int categoryId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private String createdUser;

    @Temporal(TemporalType.DATE)
    private Date dateStock;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    private String lastModifiedUser;

    private int productId;

    private int quantity;

    //private int stockId;

    private int supplierId;

    private BigDecimal version;

    public StockLogEntity() {
    }
}
