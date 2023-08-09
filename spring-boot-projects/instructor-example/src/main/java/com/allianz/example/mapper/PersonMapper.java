package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseMapper;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
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
        BeanUtils.copyProperties(entity,personDTO);
        return personDTO;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();

        BeanUtils.copyProperties(dto, personEntity);

        //TODO    personEntity.setAddressEntityList(addressMapper.dtoListToEntityList(dto.getAddressList()));
        return personEntity;
    }


    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity personEntity = new PersonEntity();

        BeanUtils.copyProperties(dto, personEntity);

        return personEntity;
    }

    @Override
    public BaseDTO entityToResponseDTO(PersonEntity entity) {
        return null;
    }


}
