package com.allianz.instructorExample.controller;

import com.allianz.instructorExample.model.AddressDTO;
import com.allianz.instructorExample.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("dto")
    public ResponseEntity<List<AddressDTO>> getDTOs() {
        List<AddressDTO> addressDTOList = addressService.getDTOs();
        return new ResponseEntity<>(addressDTOList, HttpStatus.OK);
    }


}
