package com.allianz.erp.controller;

import com.allianz.erp.entity.Bill;
import com.allianz.erp.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bill")
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id){
        return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK) ;
    }
}
