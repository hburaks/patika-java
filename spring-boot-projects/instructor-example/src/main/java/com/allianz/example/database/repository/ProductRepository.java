package com.allianz.example.database.repository;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.util.dbutil.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ProductRepository extends BaseRepository<ProductEntity> {
    @Modifying
    @Query("UPDATE ProductEntity p SET p.buyPrice = ?1 WHERE p.id = ?2")
    void updateProductPrice(BigDecimal price, Long productId);
}
