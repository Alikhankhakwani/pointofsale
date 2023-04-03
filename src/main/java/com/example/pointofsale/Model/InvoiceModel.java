package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Invoice;
import com.example.pointofsale.entity.ProductInvoice;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceModel {

    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    public InvoiceModel(Invoice invoice){
        this.setId(invoice.getId());
        this.setDate(invoice.getDate());
    }

    public InvoiceModel() {
        this.id=getId();
        this.date=getDate();

    }

    public Invoice disassemble() {
        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setDate(date);
        return invoice;
    }
    public InvoiceModel assemble(Invoice invoice) {
        InvoiceModel invoiceModel = new InvoiceModel(invoice);
        invoiceModel.setId(invoice.getId());
        invoiceModel.setDate(invoice.getDate());
        return invoiceModel;
    }

}

