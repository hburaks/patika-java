package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseMapper;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Builder
public class PersonMapper extends BaseMapper<PersonDTO, PersonEntity, PersonRequestDTO, BaseDTO> {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public PersonDTO entityToDTO(PersonEntity entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setTc(entity.getTc());
        personDTO.setName(entity.getName());
        personDTO.setSurname(entity.getSurname());
        personDTO.setId(entity.getId());
        personDTO.setUuid(entity.getUuid());
        personDTO.setBirthYear(entity.getBirthYear());
        personDTO.setCreationDate(entity.getCreationDate());
        personDTO.setUpdatedDate(entity.getUpdatedDate());
        return null;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setBirthYear(dto.getBirthYear());
        personEntity.setName(dto.getName());
        dto.getName();
        personEntity.setSurname(dto.getSurname());
        dto.getSurname();
        personEntity.setTc(dto.getTc());
        dto.getTc();
        personEntity.setAddressEntityList(addressMapper.dtoListToEntityList(dto.getAddressList()));
        return personEntity;
    }


    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setBirthYear(dto.getBirthYear());
        personEntity.setName(dto.getName());
        dto.getName();
        personEntity.setSurname(dto.getSurname());
        dto.getSurname();
        personEntity.setTc(dto.getTc());
        dto.getTc();

        return personEntity;
    }

    @Override
    public BaseDTO entityToResponseDTO(PersonEntity entity) {
        return null;
    }


}
