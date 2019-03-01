package com.pushbutton.controllers;

import com.pushbutton.models.Phone;
import com.pushbutton.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    //TODO PUT!!!
    @PostMapping("register-phone")
    public ResponseEntity<Void> register(@RequestBody Phone phone) {
        phoneService.register(phone);
        return ResponseEntity.ok().build();
    }
}
