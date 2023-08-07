package com.allianz.instructorExample.service;

import com.allianz.instructorExample.database.entity.AddressEntity;
import com.allianz.instructorExample.database.repository.AddressEntityRepository;
import com.allianz.instructorExample.mapper.AddressMapper;
import com.allianz.instructorExample.model.AddressDTO;
import com.allianz.instructorExample.model.requestDTO.AddressRequestDTO;
import com.allianz.instructorExample.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService extends BaseService {

    @Autowired
    AddressEntityRepository addressEntityRepository;

    @Autowired
    AddressMapper addressMapper;


    public AddressDTO save(AddressRequestDTO dto) {

        AddressEntity addressEntity = addressMapper.requestDTOToEntity(dto);

        addressEntityRepository.save(addressEntity);

        return addressMapper.entityToDTO(addressEntity);
    }


    public AddressDTO getByUUID(UUID uuid) {



        return null;
    }


}
