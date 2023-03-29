package com.example.pointofsale.repo;

import com.example.pointofsale.entity.Invoice;
import com.example.pointofsale.entity.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long> {
}
