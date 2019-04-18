package com.pushbutton.services;

import com.pushbutton.repositories.SourceDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebService {

    @Autowired
    private SourceDeviceRepository sourceDeviceRepository;


}
