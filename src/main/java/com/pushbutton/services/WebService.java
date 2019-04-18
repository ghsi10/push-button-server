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

    public void updateSource(SourceDevice sourceDevice) {
        sourceDeviceRepository.save(sourceDevice);

    }

    public void deleteSource(SourceDevice sourceDevice) {
        sourceDeviceRepository.delete(sourceDevice);
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }

    public void addSourceType(SourceType sourceType) {
        sourceTypeRepository.save(sourceType);
    }
}
