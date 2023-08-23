package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.SettingEntity;
import com.allianz.example230821.database.repository.SettingEntityRepository;
import com.allianz.example230821.database.specification.SettingSpecification;
import com.allianz.example230821.mapper.SettingMapper;
import com.allianz.example230821.model.SettingDTO;
import com.allianz.example230821.model.requestDTO.SettingRequestDTO;
import com.allianz.example230821.service.SettingService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setting")
public class SettingController extends BaseController<
        SettingEntity,
        SettingDTO,
        SettingRequestDTO,
        SettingMapper,
        SettingEntityRepository,
        SettingSpecification,
        SettingService> {

    @Autowired
    SettingService settingService;

    @Override
    protected SettingService getService() {
        return this.settingService;
    }
}
