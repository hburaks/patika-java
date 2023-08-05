package com.allianz.erp.service;

import com.allianz.erp.database.entity.Product;
import com.allianz.erp.database.repository.ProductRepository;
import com.allianz.erp.util.config.ConfigService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    @Autowired
    ConfigService configService;

    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            product.setTaxAppliedPrice(configService.calculatePriceWithTax(product.getPrice()));
        }
        return productList;
    }

    public Product createProduct(String name, int stock, String info, BigDecimal price) {
        Product product = new Product();
        product.setName(name);
        product.setStock(stock);
        updateProductAvailability(product);
        product.setInfo(info);
        product.setPrice(price);
        product.setTaxAppliedPrice(configService.calculatePriceWithTax(price));
        productRepository.save(product);
        return product;
    }

    public Product getProductById(Long id) {
        return productRepository.getReferenceById(id);
    }

    public Product updateProductName(String name, Product product) {
        product.setName(name);
        productRepository.save(product);
        return product;
    }

    public Product updateProductInfo(String info, Product product) {
        product.setInfo(info);
        productRepository.save(product);
        return product;
    }

    public void updateProductPrice(Long productId, BigDecimal price) {
        productRepository.updateProductPrice(productId,price);
    }



    @Transactional
    public Product updateProductStock(int stock, Product product) {
        if (stock >= 0) {
            product.setStock(stock);
            updateProductAvailability(product);
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Stock is not enough!");
        }
        return product;
    }

    public Product addStockToProduct(int stock, Product product) {
        product.setStock(stock + product.getStock());
        updateProductAvailability(product);
        productRepository.save(product);
        return product;
    }

    @Transactional
    public Product subtractStockFromProduct(int stock, Product product) {
        int newStock = product.getStock() - stock;
        if (newStock >= 0) {
            product.setStock(newStock);
            updateProductAvailability(product);
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Stock is not enough!");
        }
        return product;
    }

    public void updateProductAvailability(Product product) {
        if (product.getStock() < 1) {
            product.setProductAvailable(false);
        } else {
            product.setProductAvailable(true);
        }
        productRepository.save(product);

    }

    public boolean removeProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            productRepository.getReferenceById(id);
            return true;
        }
        return false;
    }

}
