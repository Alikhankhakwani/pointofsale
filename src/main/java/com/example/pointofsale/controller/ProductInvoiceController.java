package com.example.pointofsale.controller;

import com.example.pointofsale.Model.ProductInvoiceModel;
import com.example.pointofsale.service.ProductInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProductsInvoice")
public class ProductInvoiceController {

    @Autowired
    private ProductInvoiceService productInvoiceService;

    @GetMapping
    public List<ProductInvoiceModel> getAllProductInvoices() {
        return productInvoiceService.getAllProductInvoices();
    }

    @GetMapping("/{id}")
    public ProductInvoiceModel getProductInvoiceById(@PathVariable Long id) {
        return productInvoiceService.getProductInvoiceById(id);
    }

    @PostMapping
    public ProductInvoiceModel createProductInvoice(@RequestBody ProductInvoiceModel productInvoiceModel) {
        return productInvoiceService.createProductInvoice(productInvoiceModel);
    }

//    @GetMapping("/{invoiceId}/total")
//    public Double getTotalPriceForInvoice(@PathVariable Long invoiceId) {
//        return productInvoiceService.getTotalPriceForInvoice(invoiceId);
//    }

    @PutMapping("/{id}")
    public ProductInvoiceModel updateProductInvoice(@PathVariable Long id, @RequestBody ProductInvoiceModel productInvoiceModel) {
        return productInvoiceService.updateProductInvoice(id, productInvoiceModel);
    }

    @DeleteMapping("/{id}")
    public void deleteProductInvoice(@PathVariable Long id) {
        productInvoiceService.deleteProductInvoice(id);
    }
}
