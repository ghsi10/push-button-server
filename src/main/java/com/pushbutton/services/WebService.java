package com.pushbutton.services;

import com.pushbutton.models.SourceDevice;
import com.pushbutton.repositories.SourceDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService {

    @Autowired
    private SourceDeviceRepository sourceDeviceRepository;


}
