package com.allianz.genericerpcrud.mapper;

import com.allianz.genericerpcrud.dto.AddressDTO;
import com.allianz.genericerpcrud.dto.requestDTO.AddressRequestDTO;
import com.allianz.genericerpcrud.entity.AddressEntity;
import com.allianz.genericerpcrud.mapper.generic.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressMapper extends BaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
    @Override
    public AddressDTO entityToDTO(AddressEntity entity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCreationDate(entity.getCreationDate());
        addressDTO.setUuid(entity.getUuid());
        addressDTO.setId(entity.getId());
        addressDTO.setAddress(entity.getAddress());
        addressDTO.setTitle(entity.getTitle());
        addressDTO.setUpdatedDate(entity.getUpdatedDate());


        return addressDTO;
    }

    @Override
    public AddressEntity requestDTOToEntity(AddressRequestDTO dto) {
        AddressEntity entity = new AddressEntity();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDTO dto) {
        return null;
    }

    @Override
    public List<AddressEntity> dtoListTOEntityList(List<AddressDTO> addressDTOS) {
        return null;
    }

    @Override
    public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
        return super.entityListToDTOList(addressEntities);
    }
}
