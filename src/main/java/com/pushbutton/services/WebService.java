package com.pushbutton.services;

import com.pushbutton.models.Message;
import com.pushbutton.models.SourceDevice;
import com.pushbutton.models.SourceType;
import com.pushbutton.repositories.MessageRepository;
import com.pushbutton.repositories.SourceDeviceRepository;
import com.pushbutton.repositories.SourceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class WebService {

    private final SourceDeviceRepository sourceDeviceRepository;
    private final MessageRepository messageRepository;
    private final SourceTypeRepository sourceTypeRepository;

    @Autowired
    public WebService(SourceDeviceRepository sourceDeviceRepository, MessageRepository messageRepository, SourceTypeRepository sourceTypeRepository) {
        this.sourceDeviceRepository = sourceDeviceRepository;
        this.messageRepository = messageRepository;
        this.sourceTypeRepository = sourceTypeRepository;
    }


    public Map<String, List<SourceDevice>> getAllSourcesData() {
        return Collections.singletonMap("sources", sourceDeviceRepository.findAll());
    }

    public Optional<SourceDevice> getSourceDataById(String id) {
        return sourceDeviceRepository.findById(id);
    }

    public void updateSource(Map request) {
        Optional<SourceDevice> source = sourceDeviceRepository.findById((String) request.get("sourceId"));
        SourceDevice sourceDevice = source.get();
        sourceDevice.setDescription((String) request.get("description"));
        Message message = messageRepository.findById(((Double) request.get("messageId")).intValue()).get();
        sourceDevice.setMessage(message);
        SourceType type = sourceTypeRepository.findById(((Double) request.get("sourceTypeId")).intValue()).get();
        sourceDevice.setSourceType(type);
        sourceDeviceRepository.save(sourceDevice);
    }

    public void deleteSource(Map request) {
        String sourceId = (String) request.get("sourceId");
        sourceDeviceRepository.deleteById(sourceId);
    }

    public void addSource(Map request) {

    }

}
