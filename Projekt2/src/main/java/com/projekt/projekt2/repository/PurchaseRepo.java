package com.projekt.projekt2.repository;

import com.projekt.projekt2.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
    Purchase findPurchaseById(Long id);
}
