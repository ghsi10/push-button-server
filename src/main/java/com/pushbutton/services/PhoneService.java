package com.pushbutton.services;

import com.pushbutton.models.Phone;
import com.pushbutton.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public void register(Phone phone) {
        if (!phoneRepository.findById(phone.getToken()).isPresent())
            phoneRepository.save(phone);
    }
}
