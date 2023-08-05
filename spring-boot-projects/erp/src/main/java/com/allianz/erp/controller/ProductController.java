package com.allianz.erp.controller;

import com.allianz.erp.database.entity.Product;
import com.allianz.erp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProductList() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<Integer> getProductStockById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id).getStock(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product.getName(), product.getStock(), product.getInfo(), product.getPrice()), HttpStatus.OK);
    }

    @PutMapping("update/name/{id}")
    public ResponseEntity<Product> updateProductName(@RequestBody String name, @PathVariable Long id) {
        ResponseEntity<Product> response = getProductById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Product product = response.getBody();
            productService.updateProductName(name, product);

            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/info/{id}")
    public ResponseEntity<Product> updateProductInfo(@RequestBody String info, @PathVariable Long id) {
        ResponseEntity<Product> response = getProductById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Product product = response.getBody();
            productService.updateProductInfo(info, product);

            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/stock/{id}")
    public ResponseEntity<Product> updateProductStock(@RequestBody int stock, @PathVariable Long id) {
        ResponseEntity<Product> response = getProductById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Product product = response.getBody();
            productService.updateProductStock(stock, product);

            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/price/{price}/id/{id}")
    public ResponseEntity<Product> updateProductPrice(@PathVariable Long id, @PathVariable BigDecimal price) {
        ResponseEntity<Product> response = getProductById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Product product = response.getBody();
            productService.updateProductPrice(id, price);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("add/stock/{stock}/id/{id}")
    public ResponseEntity<Product> addStockToProduct(@PathVariable int stock, @PathVariable Long id) {
        ResponseEntity<Product> response = getProductById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Product product = response.getBody();
            productService.addStockToProduct(stock, product);

            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("subtract/stock/{stock}/id/{id}")
    public ResponseEntity<Product> subtractStockFromProduct(@PathVariable int stock, @PathVariable Long id) {
        ResponseEntity<Product> response = getProductById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Product product = response.getBody();
            productService.subtractStockFromProduct(stock, product);

            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeProduct(@PathVariable Long id) {
        boolean removed = productService.removeProduct(id);
        if (removed) {
            return new ResponseEntity<>("Product removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }


}
