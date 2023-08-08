package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseMapper;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class AddressMapper extends BaseMapper<AddressDTO, AddressEntity, AddressRequestDTO, BaseDTO> {
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
    public AddressEntity dtoToEntity(AddressDTO dto) {
        AddressEntity addressEntity = AddressEntity.builder()
                .address(dto.getAddress())
                .title(dto.getTitle())
                .build();
        return addressEntity;
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
    public BaseDTO entityToResponseDTO(AddressEntity entity) {
        return null;
    }
}
