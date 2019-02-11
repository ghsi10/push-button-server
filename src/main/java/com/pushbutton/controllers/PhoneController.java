package com.pushbutton.controllers;

import com.pushbutton.models.Phone;
import com.pushbutton.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/add/{name}")
    public void add(@PathVariable String name) {
        phoneRepository.save(Phone.of(name, "wfwefwef"));
    }

    @GetMapping("/select")
    public List<Phone> select() {
        return phoneRepository.findAll();
    }

}
