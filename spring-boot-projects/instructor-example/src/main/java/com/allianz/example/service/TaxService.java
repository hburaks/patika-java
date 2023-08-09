package com.allianz.example.service;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxRepository;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class TaxService extends BaseService<TaxEntity> {

    @Autowired
    TaxRepository taxRepository;



    public BigDecimal calculatePriceWithTax(BigDecimal price, String taxCode) {
        BigDecimal taxAmount = price.multiply(taxRepository.findByCode(taxCode).getRate()) ;
        return price.add(taxAmount);
    }

    public BigDecimal calculateTaxAmount(BigDecimal price, String taxCode){
        return price.multiply(taxRepository.findByCode(taxCode).getRate());
    }
}
