package com.allianz.genericerpcrud.controller;

import com.allianz.genericerpcrud.controller.generic.ControllerGenericImpl;
import com.allianz.genericerpcrud.entity.AddressEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/address")
public class AddressControllerImpl extends ControllerGenericImpl<AddressEntity> implements AddressController {
}
