package com.example.pointofsale.service;

import com.example.pointofsale.Model.ProductInvoiceModel;
import com.example.pointofsale.entity.ProductInvoice;
import com.example.pointofsale.repo.ProductInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


import java.util.List;

@Service
public class ProductInvoiceService {

    @Autowired
    private ProductInvoiceRepository productInvoiceRepository;

    public List<ProductInvoiceModel> getAllProductInvoices() {
        List<ProductInvoice> productInvoices = productInvoiceRepository.findAll();
        return productInvoices.stream()
                .map(ProductInvoiceModel::new)
                .collect(Collectors.toList());
    }

    public ProductInvoiceModel getProductInvoiceById(Long id) {
        ProductInvoice productInvoice = productInvoiceRepository.findById((id)).orElse(null);
        if (productInvoice != null) {
            return new ProductInvoiceModel(productInvoice);
        }
        return null;
    }

    public ProductInvoiceModel createProductInvoice(ProductInvoiceModel productInvoiceModel) {
        ProductInvoice productInvoice = productInvoiceModel.disassemble();
        productInvoice = productInvoiceRepository.save(productInvoice);
        return new ProductInvoiceModel(productInvoice);
    }

//    public Long getTotalPriceForInvoice(Long invoiceId) {
//        List<ProductInvoice> productInvoices = productInvoiceRepository.findByInvoiceId(invoiceId);
//        Double totalPrice = 0.0;
//        for (ProductInvoice productInvoice : productInvoices) {
//            totalPrice += productInvoice.getTotal();
//        }
//        return totalPrice;
//    }

    public ProductInvoiceModel updateProductInvoice(Long id, ProductInvoiceModel productInvoiceModel) {
        ProductInvoice productInvoice = productInvoiceModel.disassemble();
        productInvoice.setId(id);
        productInvoice = productInvoiceRepository.save(productInvoice);
        return new ProductInvoiceModel(productInvoice);
    }

    public void deleteProductInvoice(Long id) {
        productInvoiceRepository.deleteById((id));
    }
}



