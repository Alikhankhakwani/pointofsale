package com.example.pointofsale.controller;

import com.example.pointofsale.Model.InvoiceModel;
import com.example.pointofsale.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    public InvoiceService invoiceService;
    @GetMapping(path = "/listInvoice" )
    public List<InvoiceModel> getSInvoice()
    {
        return invoiceService.findInvoice();
    }

    @GetMapping("/Invoice/{id}" )
    public List<InvoiceModel> getSupplier(@PathVariable("id") Long Id)
    {
        return invoiceService.getInvoice(Id);
    }
    @PostMapping("/saveInvoice")
    public String addInvoice(@RequestBody InvoiceModel invoiceModel){
        return invoiceService.save(invoiceModel);
    }
    @DeleteMapping("/deleteInvoice/{id}")
    public void delete(@PathVariable("id")Long invoiceId){
        invoiceService.deleteInvoice(invoiceId);
    }


}
