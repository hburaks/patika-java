package com.allianz.instructorExample.util;

import com.allianz.instructorExample.util.dbutil.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseService<DTO extends BaseDTO, T extends BaseEntity> {
    @Autowired
    protected BaseRepository<T> baseRepository;

    @Autowired
    BaseMapper baseMapper;

    public List<BaseDTO> getDTOs() {
        List<BaseDTO> baseDTOList = baseMapper.entityListToDTOList(baseRepository.findAll());
        return baseDTOList;
    }




}
