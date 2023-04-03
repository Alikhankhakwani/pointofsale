package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Supplier;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor

public class SupplierModel {
    private Long id;
    private String name;
    private String company;
    private BigDecimal contact;


    public SupplierModel(Supplier supplier) {
       this.setId(getId());
       this.setName(getName());
       this.setCompany(getCompany());
       this.setContact(getContact());

    }

    public SupplierModel(){
        this.id=getId();
        this.name=getName();
        this.company=getCompany();
        this.contact=getContact();
    }

    public Supplier disassemble() {
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setName(name);
        supplier.setCompany(company);
        supplier.setContact(contact);
        return supplier;
    }


    public SupplierModel assemble (Supplier supplier){
        SupplierModel supplierModel = new SupplierModel();
        supplierModel.setId(supplierModel.getId());
        supplierModel.setName(supplierModel.getName());
        supplierModel.setCompany(supplierModel.getCompany());
        supplierModel.setContact(supplierModel.getContact());
        return supplierModel;


    }
}
