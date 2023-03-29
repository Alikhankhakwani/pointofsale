package com.example.pointofsale.repo;

import com.example.pointofsale.entity.Stock;
import com.example.pointofsale.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
