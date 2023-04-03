package com.example.pointofsale.service;

import com.example.pointofsale.Model.InvoiceModel;
//import com.example.pointofsale.Model.SupplierModel;
import com.example.pointofsale.entity.Invoice;
import com.example.pointofsale.entity.Supplier;
import com.example.pointofsale.repo.InvoiceRepository;
import com.example.pointofsale.repo.ProductInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
@Autowired
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public InvoiceModel save(InvoiceModel invoiceModel) {
        Invoice invoice = invoiceModel.disassemble();
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return new InvoiceModel().assemble(savedInvoice);
    }

    public InvoiceModel findById(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        if (invoice == null) {
            return null;
        }
        return new InvoiceModel().assemble(invoice);
    }

    public List<InvoiceModel> findAll() {
        List<Invoice> invoices = invoiceRepository.findAll();
        List<InvoiceModel> invoiceModels = new ArrayList<>();
        for (Invoice invoice : invoices) {
            invoiceModels.add(new InvoiceModel().assemble(invoice));
        }
        return invoiceModels;
    }

    public void deleteById(Long id) {
        invoiceRepository.deleteById(id);
    }

}




