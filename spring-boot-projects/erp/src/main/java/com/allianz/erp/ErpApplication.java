package com.allianz.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class ErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }

}

//TODO ortak repo interface sorulacak
//TODO update stock api gerekli mi serviste kalsa yeterli mi?
//TODO @Autowired doğrusu nedir? Ayağa kalkarken set veya constructor hangisi çalışır?