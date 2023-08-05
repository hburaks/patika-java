package com.allianz.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }

}

//TODO ortak repo interface sorulacak
//TODO update stock api gerekli mi serviste kalsa yeterli mi?
//TODO @Autowired doğrusu nedir? Ayağa kalkarken set veya constructor hangisi çalışır?