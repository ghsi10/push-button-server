package com.pushbutton.controllers;

import com.pushbutton.Exceptions.ArgumentNotFoundException;
import com.pushbutton.services.SourceDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourceDeviceController {

    @Autowired
    private SourceDeviceService sourceDeviceService;

    @PostMapping("/click/{id}")
    public ResponseEntity<Void> clickButton(@PathVariable String id) throws ArgumentNotFoundException {
        sourceDeviceService.click(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(ArgumentNotFoundException.class)
    public ResponseEntity<Void> ArgumentNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }
}
