package com.allianz.erp.util.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter @Setter
@Configuration
public class AppConfig {

    @Value("${tax.rate}")
    private double taxRate;
}
