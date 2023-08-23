package com.allianz.example230821.mapper;

import com.allianz.example230821.database.entity.SettingEntity;
import com.allianz.example230821.model.SettingDTO;
import com.allianz.example230821.model.requestDTO.PageDTO;
import com.allianz.example230821.model.requestDTO.SettingRequestDTO;
import com.allianz.example230821.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class SettingMapper implements IBaseMapper<SettingDTO, SettingEntity, SettingRequestDTO> {
    @Override
    public SettingDTO entityToDTO(SettingEntity entity) {
        SettingDTO dto = new SettingDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setKey(entity.getKey());
        dto.setValue(entity.getValue());

        return dto;
    }

    @Override
    public SettingEntity dtoToEntity(SettingDTO dto) {
        SettingEntity entity = new SettingEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());

        return entity;
    }

    @Override
    public List<SettingDTO> entityListToDTOList(List<SettingEntity> settingEntities) {
        List<SettingDTO> dtoList = new ArrayList<>();
        for (SettingEntity entity : settingEntities) {
            SettingDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<SettingEntity> dtoListTOEntityList(List<SettingDTO> settingDTOS) {
        List<SettingEntity> dtoList = new ArrayList<>();
        for (SettingDTO dto : settingDTOS) {
            SettingEntity entity = dtoToEntity(dto);
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public SettingEntity requestDTOToEntity(SettingRequestDTO dto) {
        SettingEntity entity = new SettingEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
        return entity;
    }

    @Override
    public List<SettingEntity> requestDtoListTOEntityList(List<SettingRequestDTO> settingRequestDTOS) {
        return null;
    }

    @Override
    public SettingEntity requestDtoToExistEntity(SettingEntity entity, SettingRequestDTO settingRequestDTO) {
        entity.setKey(settingRequestDTO.getKey());
        entity.setValue(settingRequestDTO.getValue());
        return entity;
    }

    @Override
    public PageDTO<SettingDTO> pageEntityToPageDTO(Page<SettingEntity> entityPage) {
        PageDTO<SettingDTO> dtoPage = new PageDTO<>();
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
