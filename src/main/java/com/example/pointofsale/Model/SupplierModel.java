package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Supplier;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SupplierModel {
    private long Id;
    private String supplierName;
    private String supplierCompany;
    private BigDecimal supplierContact;


    public SupplierModel(Supplier supplier) {
        this.Id=supplier.getId();
        this.supplierName=supplier.getSupplierName();
        this.supplierCompany=supplier.getSupplierCompany();
       this.supplierContact=supplier.getSupplierContact();

    }

    public Supplier disassemble() {
        Supplier supplier = new Supplier();

        supplier.setId(Id);
        supplier.setSupplierName(supplierName);
        supplier.setSupplierCompany(supplierCompany);
        supplier.setSupplierContact(supplierContact);

        return supplier;
    }


    public SupplierModel assemble (Supplier supplier){
        SupplierModel supplierModel = new SupplierModel();

        supplierModel.setId(supplier.getId());
        supplierModel.setSupplierName(supplier.getSupplierName());
        supplierModel.setSupplierCompany(supplier.getSupplierCompany());
        supplierModel.setSupplierContact(supplier.getSupplierContact());
        return supplierModel;


    }
}
