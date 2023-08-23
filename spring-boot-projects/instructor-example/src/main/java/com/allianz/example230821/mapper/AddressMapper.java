package com.allianz.example230821.mapper;

import com.allianz.example230821.database.entity.AddressEntity;
import com.allianz.example230821.model.AddressDTO;
import com.allianz.example230821.model.requestDTO.AddressRequestDTO;
import com.allianz.example230821.model.requestDTO.PageDTO;
import com.allianz.example230821.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper implements IBaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
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
        return null;
    }

    @Override
    public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
        List<AddressDTO> addressDTOList = new ArrayList<>();

        for (AddressEntity addressEntity : addressEntities) {
            addressDTOList.add(entityToDTO(addressEntity));
        }

        return addressDTOList;
    }

    @Override
    public List<AddressEntity> dtoListTOEntityList(List<AddressDTO> addressDTOS) {
        return null;
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
    public List<AddressEntity> requestDtoListTOEntityList(List<AddressRequestDTO> addressRequestDTOS) {
        return null;
    }

    @Override
    public AddressEntity requestDtoToExistEntity(AddressEntity entity, AddressRequestDTO addressRequestDTO) {
        entity.setAddress(addressRequestDTO.getAddress());
        entity.setTitle(addressRequestDTO.getTitle());
        return entity;
    }

    @Override
    public PageDTO<AddressDTO> pageEntityToPageDTO(Page<AddressEntity> entityPage) {
        PageDTO<AddressDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(entityPage.getTotalPages());
        dtoPage.setTotalElements(entityPage.getTotalElements());
        dtoPage.setSort(entityPage.getSort());
        dtoPage.setSize(entityPage.getSize());
        dtoPage.setNumber(entityPage.getNumber());
        dtoPage.setContent(entityListToDTOList(entityPage.getContent()));
        dtoPage.setHasContent(entityPage.hasContent());

        return dtoPage;
    }


}
