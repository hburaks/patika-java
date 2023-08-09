package com.allianz.example.service;


import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductRepository;
import com.allianz.example.database.repository.TaxRepository;
import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends BaseService<ProductEntity> {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    TaxService taxService;

    @Autowired
    TaxRepository taxRepository;


    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> productList = productRepository.findAll();
        return productList;
    }

    public ProductEntity createProduct(String name, String code, ColorEnum colorEnum, int stock, String taxCode, BigDecimal price) {
        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setQuantity(stock);
        product.setCode(code);
        product.setColor(colorEnum);
        updateProductAvailability(product);
        product.setBuyPrice(price);
        product.setTax(taxRepository.findByCode(taxCode));
        product.setSellPrice(taxService.calculatePriceWithTax(price, taxCode));


        productRepository.save(product);
        return product;
    }


    public ProductEntity updateProductName(String name, ProductEntity product) {
        product.setName(name);
        productRepository.save(product);
        return product;
    }


    public void updateProductPrice(Long productId, BigDecimal price) {
        productRepository.updateProductPrice(price, productId);
    }


    @Transactional
    public ProductEntity updateProductStock(int stock, ProductEntity product) throws Exception {
        if (stock >= 0) {
            product.setQuantity(stock);
            updateProductAvailability(product);
            save(product);
        } else {
            throw new IllegalArgumentException("Stock is not enough!");
        }
        return product;
    }

    public ProductEntity addStockToProduct(int stock, ProductEntity product) {
        product.setQuantity(stock + product.getQuantity());
        updateProductAvailability(product);
        productRepository.save(product);
        return product;
    }

    @Transactional
    public ProductEntity subtractStockFromProduct(int stock, ProductEntity product) {
        int newStock = product.getQuantity() - stock;
        if (newStock >= 0) {
            product.setQuantity(newStock);
            updateProductAvailability(product);
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Stock is not enough!");
        }
        return product;
    }

    public void updateProductAvailability(ProductEntity product) {
        if (product.getQuantity() < 1) {
            product.setProductAvailable(false);
        } else {
            product.setProductAvailable(true);
        }
        try {
            save(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean removeProduct(Long id) throws Exception {
        Optional<ProductEntity> productOptional = findById(id);
        if (productOptional.isPresent()) {
            delete(id);
            findById(id);
            return true;
        }
        return false;
    }


}
