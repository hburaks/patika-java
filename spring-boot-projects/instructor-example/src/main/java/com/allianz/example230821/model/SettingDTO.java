package com.allianz.example230821.model;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

@Data
public class SettingDTO extends BaseDTO {
    private String key;
    private String value;
}
