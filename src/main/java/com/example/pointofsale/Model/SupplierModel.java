package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Supplier;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data


public class SupplierModel {
    private Long id;
    private String name;
    private String company;
    private BigDecimal contact;


//    public SupplierModel(Supplier supplier) {
//       this.setId(getId());
//       this.setName(getName());
//       this.setCompany(getCompany());
//       this.setContact(getContact());
//
//    }
public SupplierModel(Long id, String name, String company, BigDecimal contact){
        this.setId(id);
        this.setName(name);
        this.setCompany(company);
        this.setContact(contact);
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
        supplierModel.setId(supplier.getId());
        supplierModel.setName(supplier.getName());
        supplierModel.setCompany(supplier.getCompany());
        supplierModel.setContact(supplier.getContact());
        return supplierModel;


    }
}
