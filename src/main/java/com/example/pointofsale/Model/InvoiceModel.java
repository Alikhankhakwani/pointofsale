package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Invoice;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class InvoiceModel {
    private long Id;
    private String categoryName;

    private long productId;
    private String productName;
    private double quantity;
    private double total;

    public InvoiceModel(Invoice invoice) {
        this.Id=getId();
        this.categoryName=getCategoryName();
        this.productId=getProductId();
        this.productName=getProductName();
        this.quantity=getQuantity();
        this.total=getTotal();
    }

    public Invoice disassemble(){
        Invoice invoice=new Invoice();
        invoice.setId(Id);
        invoice.setCategoryName(categoryName);
        invoice.setProductId(productId);
        invoice.setProductName(productName);
        invoice.setQuantity(quantity);
        invoice.setTotal(total);
        return invoice;

    }
    public InvoiceModel assemble(Invoice invoice){
        InvoiceModel invoiceModel=new InvoiceModel();
        invoiceModel.setId(invoice.getId());
        invoiceModel.setCategoryName(invoice.getCategoryName());
        invoiceModel.setProductId(invoice.getProductId());
        invoiceModel.setProductName(invoice.getProductName());
        invoiceModel.setQuantity(invoice.getQuantity());
        invoiceModel.setTotal(invoice.getTotal());

        return invoiceModel;
    }
}
