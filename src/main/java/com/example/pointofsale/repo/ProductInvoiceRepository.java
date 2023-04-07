package com.example.pointofsale.repo;

import com.example.pointofsale.entity.ProductInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice,Long> {
    List<ProductInvoice> findByInvoiceId(Long invoiceId);
}
