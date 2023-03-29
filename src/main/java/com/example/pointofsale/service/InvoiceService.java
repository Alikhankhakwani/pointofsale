package com.example.pointofsale.service;

import com.example.pointofsale.Model.InvoiceModel;
import com.example.pointofsale.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    public InvoiceRepository invoiceRepository;

    public InvoiceModel insert(InvoiceModel invoiceModel){
        return invoiceModel.assemble(invoiceRepository.save(invoiceModel.disassemble()));
    }
    public void deleteInvoice(Long id){
        invoiceRepository.deleteById(id);
    }
}
