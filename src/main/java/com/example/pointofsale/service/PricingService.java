package com.example.pointofsale.service;

import com.example.pointofsale.Model.PricingModel;
import com.example.pointofsale.Model.ProductModel;
import com.example.pointofsale.repo.PricingRepository;
import com.example.pointofsale.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingService {
    @Autowired
    public PricingRepository pricingRepository;

    public PricingModel insert(PricingModel pricingModel){
        return pricingModel.assemble(pricingRepository.save(pricingModel.disassemble()));
    }
    public void deleteInvoice(Long id){
        pricingRepository.deleteById(id);
    }
}
