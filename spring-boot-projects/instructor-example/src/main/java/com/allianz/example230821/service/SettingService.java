package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.SettingEntity;
import com.allianz.example230821.database.repository.SettingEntityRepository;
import com.allianz.example230821.database.specification.SettingSpecification;
import com.allianz.example230821.mapper.SettingMapper;
import com.allianz.example230821.model.SettingDTO;
import com.allianz.example230821.model.requestDTO.SettingRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService extends BaseService<SettingEntity, SettingDTO, SettingRequestDTO,
        SettingMapper, SettingEntityRepository, SettingSpecification> {

    @Autowired
    SettingEntityRepository settingEntityRepository;

    @Autowired
    SettingMapper settingMapper;


    @Override
    protected SettingMapper getMapper() {
        return this.settingMapper;
    }

    @Override
    protected SettingEntityRepository getRepository() {
        return this.settingEntityRepository;
    }

    @Override
    protected SettingSpecification getSpecification() {
        return null;
    }
}
