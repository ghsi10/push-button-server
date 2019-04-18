package com.pushbutton.controllers;

import com.google.gson.Gson;
import com.pushbutton.models.SourceDevice;
import com.pushbutton.services.SourceDeviceService;
import com.pushbutton.services.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/management")
public class WebController {

    @Autowired
    private WebService webService;

    @GetMapping("/getAllSourcesData")
    public @ResponseBody
    Map<String, List<SourceDevice>> GetAllSources() {
        return webService.getAllSourcesData();
    }

    @GetMapping("/getSourceData/{id}")
    public @ResponseBody
    ResponseEntity<SourceDevice> GetSource(@PathVariable String id) {
        return ResponseEntity.of(webService.getSourceDataById(id));
    }

    @PostMapping("/updateSource")
    public ResponseEntity<Void> updateSource(@RequestBody String requestJson) {
        Gson gson = new Gson();
        Map request = gson.fromJson(requestJson, Map.class);
        webService.updateSource(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deleteSource")
    public ResponseEntity<Void> deleteSource(@RequestBody String requestJson) {
        Gson gson = new Gson();
        Map request = gson.fromJson(requestJson, Map.class);
        webService.deleteSource(request);
        return ResponseEntity.ok().build();
    }
}
