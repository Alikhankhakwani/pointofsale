package com.example.pointofsale.controller;

import com.example.pointofsale.Model.StockModel;
import com.example.pointofsale.Model.SupplierModel;
import com.example.pointofsale.service.StockService;
import com.example.pointofsale.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierModel> createSupplier(@RequestBody SupplierModel supplierModel) {
        SupplierModel createdSupplier = supplierService.createSupplier(supplierModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSupplier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierModel> getSupplierById(@PathVariable Long id) {
        SupplierModel supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierModel> updateSupplier(@PathVariable Long id, @RequestBody SupplierModel supplierModel) {
        if (!supplierModel.getId().equals(id)) {
            throw new RuntimeException("Invalid supplier id: " + supplierModel.getId());
        }
        SupplierModel updatedSupplier = supplierService.updateSupplier(supplierModel);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierById(@PathVariable Long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SupplierModel>> getAllSuppliers() {
        List<SupplierModel> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }
}

