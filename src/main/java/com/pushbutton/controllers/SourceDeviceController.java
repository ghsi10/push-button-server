package com.pushbutton.controllers;

import com.pushbutton.Exceptions.ArgumentNotFoundException;
import com.pushbutton.services.SourceDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SourceDeviceController {

    private final SourceDeviceService sourceDeviceService;

    @Autowired
    public SourceDeviceController(SourceDeviceService sourceDeviceService) {
        this.sourceDeviceService = sourceDeviceService;
    }

    @PostMapping("/click/{id}")
    public void clickButton(@PathVariable String id) throws ArgumentNotFoundException {
        sourceDeviceService.click(id);
    }

    @ExceptionHandler(ArgumentNotFoundException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public void ArgumentNotFoundExceptionHandler() {
    }
}
