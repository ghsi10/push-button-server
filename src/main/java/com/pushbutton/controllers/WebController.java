package com.pushbutton.controllers;

import com.google.gson.Gson;
import com.pushbutton.models.SourceDevice;
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
    public void updateSource(@RequestBody String requestJson) {
        webService.updateSource(requestJsonToMap(requestJson));
    }

    @PostMapping("/deleteSource")
    public void deleteSource(@RequestBody String requestJson) {
        webService.deleteSource(requestJsonToMap(requestJson));
    }

    @PostMapping("/addSource")
    public void addSource(@RequestBody String requestJson) {
        webService.addSource(requestJsonToMap(requestJson));
    }

    private Map requestJsonToMap(String requestJson) {
        Gson gson = new Gson();
        return gson.fromJson(requestJson, Map.class);
    }
}
