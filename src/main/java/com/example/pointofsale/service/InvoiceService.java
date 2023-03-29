package com.example.pointofsale.service;

import com.example.pointofsale.Model.InvoiceModel;
import com.example.pointofsale.Model.SupplierModel;
import com.example.pointofsale.entity.Invoice;
import com.example.pointofsale.entity.Supplier;
import com.example.pointofsale.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    @Autowired
    public InvoiceRepository invoiceRepository;

    public String save(InvoiceModel invoiceModel) {
        if (!invoiceRepository.existsById(invoiceModel.getId())) {
            invoiceModel.assemble(invoiceRepository.save(invoiceModel.disassemble()));
            return "Invoice Saved Successfully ";
        }

        else

        {
            return "Invoice Already Exists";
        }
    }



    public String deleteInvoice(Long id ) {
        invoiceRepository.deleteById(id);
        return "Supplier Deleted Successfully ";
    }

    public List<InvoiceModel> findInvoice() {

        List<InvoiceModel> invoiceModels = new ArrayList<>();
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice : invoices) {
            InvoiceModel invoiceModel = new InvoiceModel(invoice);
            invoiceModels.add(invoiceModel);

        }
        return invoiceModels;
    }



    public List<InvoiceModel> getInvoice(Long Id) {
        List<InvoiceModel> invoices = new ArrayList<>();
        if (Id != null) {
            invoices = List.of(invoiceRepository.findAll()
                    .stream()
                    .map(InvoiceModel::new)
                    .filter(invoiceModel -> invoiceModel.getId() == (Id))
                    .findFirst()
                    .get());

        }
        else {
            invoices = invoiceRepository.findAll()
                    .stream()
                    .map(InvoiceModel::new)
                    .collect(Collectors.toList());
        }
        return invoices;
    }
}
