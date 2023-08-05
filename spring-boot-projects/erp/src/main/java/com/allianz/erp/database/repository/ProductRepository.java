package com.allianz.erp.database.repository;

import com.allianz.erp.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Modifying
    @Query("UPDATE Product p SET p.price = ?1 WHERE p.id = ?2")
    void updateProductPrice(BigDecimal price, Long productId);
}

