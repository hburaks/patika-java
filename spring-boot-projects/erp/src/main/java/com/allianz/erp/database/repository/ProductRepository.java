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
    @Query("UPDATE Product p SET p.price = :price WHERE p.id = :productId")
    int updateProductPrice(Long productId, BigDecimal price);
}

