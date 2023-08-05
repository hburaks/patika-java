package com.allianz.erp.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConfigService {

    @Autowired
    AppConfig appConfig;

    public BigDecimal calculatePriceWithTax(BigDecimal price) {
        BigDecimal taxAmount = price.multiply(BigDecimal.valueOf(appConfig.getTaxRate())) ;
        return price.add(taxAmount);
    }

    public BigDecimal calculateTaxAmount(BigDecimal price){
        return price.multiply(BigDecimal.valueOf(appConfig.getTaxRate()));
    }

}
