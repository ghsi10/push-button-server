package com.pushbutton.controllers;

import com.pushbutton.models.Phone;
import com.pushbutton.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PutMapping("register-phone")
    public void register(@RequestBody Phone phone) {
        phoneService.register(phone);
    }
}
