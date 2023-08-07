package com.allianz.instructorExample.util;

import com.allianz.instructorExample.util.dbutil.BaseEntity;

import java.util.List;

public interface IBaseMapper<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<DTO> dtoList);

    Entity requestDTOToEntity(RequestDTO dto);


}
