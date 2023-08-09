package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseMapper;
import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Builder
public class AddressMapper extends BaseMapper<AddressDTO, AddressEntity, AddressRequestDTO, BaseDTO> {
    @Override
    public AddressDTO entityToDTO(AddressEntity entity) {
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(entity, addressDTO);

        return addressDTO;
    }



    @Override
    public AddressEntity dtoToEntity(AddressDTO dto) {
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(dto, addressEntity);
        return addressEntity;
    }

    @Override
    public AddressEntity requestDTOToEntity(AddressRequestDTO dto) {
        AddressEntity entity = new AddressEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public BaseDTO entityToResponseDTO(AddressEntity entity) {
        return null;
    }
}
