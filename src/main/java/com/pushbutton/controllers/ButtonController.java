package com.pushbutton.controllers;

import com.pushbutton.Exceptions.ArgumentNotFoundException;
import com.pushbutton.Exceptions.ConnectionException;
import com.pushbutton.services.ButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.ConnectionResetException;

@RestController
public class ButtonController {

    @Autowired
    private ButtonService buttonService;

    @PostMapping("/click-button/{id}")
    public void clickButton(@PathVariable Long id) throws ArgumentNotFoundException, ConnectionException {
        buttonService.clickButton(id);
    }

    @ExceptionHandler(ArgumentNotFoundException.class)
    public ResponseEntity ArgumentNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }

    @ExceptionHandler(ConnectionException.class)
    public ResponseEntity ConnectionExceptionHandler() {
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
    }
}
