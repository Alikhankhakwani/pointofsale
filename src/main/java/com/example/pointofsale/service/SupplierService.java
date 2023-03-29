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
import java.util.stream.Collectors;

@Service
public class SupplierService {
    @Autowired
    public SupplierRepository supplierRepository;


    public String save(SupplierModel supplierModel) {
        if (!supplierRepository.existsById(supplierModel.getId())) {
            supplierModel.assemble(supplierRepository.save(supplierModel.disassemble()));
            return "Supplier Saved Successfully ";
        }

        else

        {
            return "Supplier Already Exists";
        }
    }



    public String deleteSupplier(Long id ) {
        supplierRepository.deleteById(id);
        return "Supplier Deleted Successfully ";
    }

    public List<SupplierModel> findSupplier() {

        List<SupplierModel> supplierModels = new ArrayList<>();
        List<Supplier> suppliers = supplierRepository.findAll();
        for (Supplier supplier : suppliers) {
            SupplierModel supplierModel = new SupplierModel(supplier);
            supplierModels.add(supplierModel);

        }
        return supplierModels;
    }



    public List<SupplierModel> getSuppliers(Long Id) {
        List<SupplierModel> supplies = new ArrayList<>();
        if (Id != null) {
            supplies = List.of(supplierRepository.findAll()
                    .stream()
                    .map(SupplierModel::new)
                    .filter(suppliesModel -> suppliesModel.getId() == (Id))
                    .findFirst()
                    .get());

        }
        else {
            supplies = supplierRepository.findAll()
                    .stream()
                    .map(SupplierModel::new)
                    .collect(Collectors.toList());
        }
        return supplies;
    }
}
