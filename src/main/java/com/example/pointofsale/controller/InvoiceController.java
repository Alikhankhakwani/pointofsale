package com.example.pointofsale.controller;

import com.example.pointofsale.Model.InvoiceModel;
import com.example.pointofsale.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
@Autowired
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<InvoiceModel> createInvoice(@RequestBody InvoiceModel invoiceModel) {
        InvoiceModel savedInvoiceModel = invoiceService.save(invoiceModel);
        return ResponseEntity.ok(savedInvoiceModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceModel> getInvoiceById(@PathVariable Long id) {
        InvoiceModel invoiceModel = invoiceService.findById(id);
        if (invoiceModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(invoiceModel);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceModel>> getAllInvoices() {
        List<InvoiceModel> invoiceModels = invoiceService.findAll();
        return ResponseEntity.ok(invoiceModels);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceById(@PathVariable Long id) {
        invoiceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

