package com.allianz.example230821;

import com.allianz.example230821.database.repository.CategoryEntityRepository;
import com.allianz.example230821.database.repository.ProductEntityRepository;
import com.allianz.example230821.service.CategoryService;
import com.allianz.example230821.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootDers2Application {

    @Autowired
    ProductService productService;


    @Autowired
    CategoryService categoryService;


    @Autowired
    ProductEntityRepository repository;


    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDers2Application.class, args);

    }


}
