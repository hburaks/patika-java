package com.allianz.example230821.model.requestDTO;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

@Data
public class SettingRequestDTO extends BaseDTO {
    private String key;
    private String value;
}
