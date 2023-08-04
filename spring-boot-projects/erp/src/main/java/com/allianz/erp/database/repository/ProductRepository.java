package com.allianz.erp.database.repository;

import com.allianz.erp.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getById(Long id);

    Product removeById(Long id);

    Product updateById(Long id);

}
