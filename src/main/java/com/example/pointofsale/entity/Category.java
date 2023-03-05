package com.example.pointofsale.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@Entity

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_Id")
    private int categoryId;
    @Column(name = "category_Name")
    private String categoryName;
    @Column(name = "createdDate_Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Column(name = "created_User")
    private String createdUser;
    @Column(name = "lastModified_DateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;
    @Column(name = "lastModified_User")
    private String lastModifiedUser;
    @Column(name = "version")
    private BigDecimal version;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


    @OneToMany(mappedBy = "category")
    private List<Stock> stocks;
}
