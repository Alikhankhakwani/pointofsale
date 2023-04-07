package com.example.pointofsale.controller;

import com.example.pointofsale.Model.StockModel;
import com.example.pointofsale.Model.SupplierModel;
import com.example.pointofsale.service.StockService;
import com.example.pointofsale.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierModel>> getAllSuppliers() {
        List<SupplierModel> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierModel> getSupplierById(@PathVariable Long id) {
        SupplierModel supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping
    public ResponseEntity<SupplierModel> createSupplier(@RequestBody SupplierModel supplierModel) {
        SupplierModel createdSupplier = supplierService.createSupplier(supplierModel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdSupplier.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierModel> updateSupplier(@PathVariable Long id, @RequestBody SupplierModel supplierModel) {
        SupplierModel updatedSupplier = supplierService.updateSupplier(id, supplierModel);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
