package com.allianz.genericerpcrud.dto.requestDTO.generic;

import com.allianz.genericerpcrud.dto.generic.BaseDTO;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseRequestDTO extends BaseDTO {

    private Long id;
    private UUID uuid;
    private Date creationDate;
    private Date updatedDate;




}