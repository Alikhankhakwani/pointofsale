package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int refId;

    private String branchId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private String createdUser;

    @Temporal(TemporalType.DATE)
    private Date dateStock;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    private String lastModifiedUser;

    private int quantity;

    //private int stockId;

    private BigDecimal version;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="product_Id")
    private Product product;

    //bi-directional many-to-one association to Supplier
    @ManyToOne
    @JoinColumn(name="supplier_Id")
    private Supplier supplier;

    //bi-directional many-to-one association to Category
    @ManyToOne
    @JoinColumn(name="category_Id")
    private Category category;

    public Stock() {
    }
}
