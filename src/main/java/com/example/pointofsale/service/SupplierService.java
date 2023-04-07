package com.example.pointofsale.service;

import com.example.pointofsale.Model.StockModel;
import com.example.pointofsale.Model.SupplierModel;
import com.example.pointofsale.entity.Stock;
import com.example.pointofsale.entity.Supplier;
import com.example.pointofsale.repo.StockRepository;
import com.example.pointofsale.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierModel> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    public SupplierModel getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id " + id));
        return mapToModel(supplier);
    }

    public SupplierModel createSupplier(SupplierModel supplierModel) {
        Supplier supplier = supplierModel.disassemble();
        Supplier savedSupplier = supplierRepository.save(supplier);
        return mapToModel(savedSupplier);
    }

    public SupplierModel updateSupplier(Long id, SupplierModel supplierModel) {
        Supplier existingSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id " + id));
        Supplier updatedSupplier = supplierModel.disassemble();
        updatedSupplier.setId(existingSupplier.getId());
        Supplier savedSupplier = supplierRepository.save(updatedSupplier);
        return mapToModel(savedSupplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    private SupplierModel mapToModel(Supplier supplier) {
        return new SupplierModel(
                supplier.getId(),
                supplier.getName(),
                supplier.getCompany(),
                supplier.getContact()
        );
    }
}
