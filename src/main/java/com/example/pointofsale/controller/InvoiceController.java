package com.example.pointofsale.controller;

import com.example.pointofsale.Model.CategoryModel;
import com.example.pointofsale.Model.InvoiceModel;
import com.example.pointofsale.entity.Invoice;
import com.example.pointofsale.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {
    @Autowired
    public InvoiceService invoiceService;
    @PostMapping("/saveInvoice")
    public InvoiceModel addInvoice(@RequestBody InvoiceModel invoiceModel){
        return invoiceService.insert(invoiceModel);
    }
    @DeleteMapping("/deleteInvoice/{id}")
    public void delete(@PathVariable("id")Long invoiceId){
        invoiceService.deleteInvoice(invoiceId);
    }


}
