package com.example.pointofsale.repo;

import com.example.pointofsale.entity.ProductInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice,Long> {
    List<ProductInvoice> findByInvoiceId(Long invoiceId);
}
