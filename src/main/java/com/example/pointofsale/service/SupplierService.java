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

    public SupplierModel createSupplier(SupplierModel supplierModel) {
        Supplier supplier = supplierModel.disassemble();
        supplier = supplierRepository.save(supplier);
        return new SupplierModel(supplier);
    }

    public SupplierModel getSupplierById(Long id) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (supplierOptional.isPresent()) {
            return new SupplierModel(supplierOptional.get());
        } else {
            throw new RuntimeException("Supplier not found with id: " + id);
        }
    }

    public SupplierModel updateSupplier(SupplierModel supplierModel) {
        Supplier supplier = supplierModel.disassemble();
        supplier = supplierRepository.save(supplier);
        return new SupplierModel(supplier);
    }

    public void deleteSupplierById(Long id) {
        supplierRepository.deleteById(id);
    }

    public List<SupplierModel> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream().map(SupplierModel::new).collect(Collectors.toList());
    }
}

