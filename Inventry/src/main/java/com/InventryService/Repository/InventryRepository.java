package com.InventryService.Repository;

import com.InventryService.Entity.Inventry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventryRepository extends JpaRepository<Inventry, Long> {
    Optional<Inventry> findBySkuCode(String skuCode);
}