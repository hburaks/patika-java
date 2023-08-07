


package com.allianz.instructorExample.util;

        import java.util.ArrayList;
        import java.util.List;

public abstract class BaseMapper<BaseDTO extends com.allianz.instructorExample.util.BaseDTO, BaseEntity extends com.allianz.instructorExample.util.dbutil.BaseEntity, BaseRequestDTO extends com.allianz.instructorExample.util.BaseDTO> implements IBaseMapper<BaseDTO, BaseEntity, BaseRequestDTO> {

    @Override
    public abstract BaseDTO entityToDTO(BaseEntity entity);

    @Override
    public abstract BaseEntity dtoToEntity(BaseDTO dto);

    @Override
    public abstract List<BaseEntity> dtoListTOEntityList(List<BaseDTO> baseDTOS);

    @Override
    public abstract BaseEntity requestDTOToEntity(BaseRequestDTO dto);

    public List<BaseDTO> entityListToDTOList(List<BaseEntity> baseEntities) {
        List<BaseDTO> baseDTOList = new ArrayList<>();

        for (BaseEntity baseEntity : baseEntities) {
            baseDTOList.add(entityToDTO(baseEntity));
        }

        return baseDTOList;
    }
}

