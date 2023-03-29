package com.example.pointofsale.controller;

import com.example.pointofsale.Model.StockModel;
import com.example.pointofsale.Model.SupplierModel;
import com.example.pointofsale.service.StockService;
import com.example.pointofsale.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {
    @Autowired
    public SupplierService supplierService;


    @GetMapping(path = "/listSupplier" )
    public List<SupplierModel> getSupplier()
    {
        return supplierService.findSupplier();
    }

    @GetMapping("/Supplier/{id}" )
    public List<SupplierModel> getSupplier(@PathVariable("id") Long Id)
    {
        return supplierService.getSuppliers(Id);
    }
    @PostMapping("/saveSupplier")
    public String addSupplier(@RequestBody SupplierModel supplierModel) {
        return   supplierService.save(supplierModel);

    }


    @DeleteMapping("/deleteSupplier/{id}")
    public String delete(@PathVariable("id") Long Id) {
        supplierService.deleteSupplier(Id);
        return "Supplier Deleted Successfully ";
    }
}
