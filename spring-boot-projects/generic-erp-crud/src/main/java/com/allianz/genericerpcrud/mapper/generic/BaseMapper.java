


package com.allianz.genericerpcrud.mapper.generic;

import com.allianz.genericerpcrud.dto.generic.BaseDTO;
import com.allianz.genericerpcrud.entity.generic.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapper<DTO extends BaseDTO, Entity extends BaseEntity, RequestDto extends BaseDTO> implements IBaseMapper<DTO, Entity, RequestDto> {

    @Override
    public abstract DTO entityToDTO(Entity entity);

    @Override
    public abstract Entity dtoToEntity(DTO dto);

    @Override
    public List<Entity> dtoListTOEntityList(List<DTO> baseDTOS){
        List<Entity> entities = new ArrayList<>();
        for(DTO dto : baseDTOS){
            entities.add(dtoToEntity(dto));
        }
        return entities;
    };

    @Override
    public abstract Entity requestDTOToEntity(RequestDto dto);

    public List<DTO> entityListToDTOList(List<Entity> baseEntities) {
        List<DTO> baseDTOList = new ArrayList<>();

        for (Entity baseEntity : baseEntities) {
            baseDTOList.add(entityToDTO(baseEntity));
        }

        return baseDTOList;
    }
}

