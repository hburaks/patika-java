package com.allianz.erp.service;

import com.allianz.erp.database.entity.Product;
import com.allianz.erp.database.repository.ProductRepository;
import com.allianz.erp.util.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ConfigService configService;

    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        for(Product product : productList){
            product.setTaxAppliedPrice(configService.calculatePriceWithTax(product.getPrice()));
            //TODO:update işlemini program ayağa kalkarken yap?
        }
        return productRepository.findAll();
    }

    public Product createProduct(String name, int stock, String info, BigDecimal price) {
        Product product = new Product();
        product.setName(name);
        product.setStock(stock);
        if(stock>0){
            product.setProductAvailable(true);
        } else {
            product.setProductAvailable(false);
        }
        product.setInfo(info);
        product.setPrice(price);
        product.setTaxAppliedPrice(configService.calculatePriceWithTax(price));

        productRepository.save(product);
        return product;
    }

}
