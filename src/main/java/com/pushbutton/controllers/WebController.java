package com.pushbutton.controllers;

import com.pushbutton.models.Message;
import com.pushbutton.models.SourceDevice;
import com.pushbutton.models.SourceType;
import com.pushbutton.services.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/management")
public class WebController {

    private final WebService webService;

    @Autowired
    public WebController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping("/getAllSourcesData")
    public Map<String, List<SourceDevice>> GetAllSources() {
        return webService.getAllSourcesData();
    }

    @GetMapping("/getSourceData/{id}")
    public SourceDevice GetSource(@PathVariable String id) {
        return webService.getSourceDataById(id).get();
    }

    @PostMapping("/updateSource")
    public void updateSource(@RequestBody SourceDevice sourceDevice) {
        webService.updateSource(sourceDevice);
    }

    @PostMapping("/deleteSource")
    public void deleteSource(@RequestBody SourceDevice sourceDevice) {
        webService.deleteSource(sourceDevice);
    }


    @PostMapping("/addMessage")
    private void addMessage(@RequestBody Message message) {
        webService.addMessage(message);
    }

    @PostMapping("/addSourceType")
    private void addSourceType(@RequestBody SourceType sourceType) {
        webService.addSourceType(sourceType);
    }
}
