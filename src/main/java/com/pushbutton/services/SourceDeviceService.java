package com.pushbutton.services;

import com.pushbutton.Exceptions.ArgumentNotFoundException;
import com.pushbutton.models.Message;
import com.pushbutton.models.Phone;
import com.pushbutton.models.SourceDevice;
import com.pushbutton.models.SourceType;
import com.pushbutton.repositories.MessageRepository;
import com.pushbutton.repositories.SourceDeviceRepository;
import com.pushbutton.repositories.SourceTypeRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SourceDeviceService {

    @Value("${firebase.key}")
    String firebaseKey;
    @Value("${firebase.url}")
    String firebaseUrl;

    @Autowired
    private SourceDeviceRepository sourceDeviceRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private SourceTypeRepository sourceTypeRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final int NO_AUDIO = -1;

    public void click(String id) throws ArgumentNotFoundException {
        SourceDevice sourceDevice = sourceDeviceRepository.findById(id).orElseThrow(ArgumentNotFoundException::new);
        RestTemplate restTemplate = new RestTemplate();
        for (Phone phone : sourceDevice.getPhones()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "key=" + firebaseKey);
            httpHeaders.set("Content-Type", "application/json");
            JSONObject data = new JSONObject();
            data.put("SourceId", sourceDevice.getId());
            data.put("Content", sourceDevice.getMessage().getContent());
            data.put("MessageId", sourceDevice.getMessage().getAudio() ? sourceDevice.getMessage().getId() : NO_AUDIO);
            JSONObject notification = new JSONObject();
            notification.put("text", "New notification");
            JSONObject json = new JSONObject();
            json.put("data", data);
            json.put("notification", notification);
            json.put("to", phone.getToken());
            HttpEntity<String> httpEntity = new HttpEntity<>(json.toString(), httpHeaders);
            if (restTemplate.postForEntity(firebaseUrl, httpEntity, Object.class).getStatusCode().isError())
                logger.error(String.format("Couldn't send message to %s from %s", phone.getPhoneNumber(), sourceDevice.getId()));
        }
    }

    public Map<String, List<SourceDevice>> getAllSourcesData(){
        return Collections.singletonMap("sources",sourceDeviceRepository.findAll());
    }

    public Optional<SourceDevice> getSourceDataByid(String id) {
        return sourceDeviceRepository.findById(id);
    }

    public void updateSource(Map request) {
        Optional source= sourceDeviceRepository.findById((String)request.get("sourceId"));
        SourceDevice sourceDevice = (SourceDevice)source.get();
        sourceDevice.setDescription((String)request.get("description"));
        Message message = messageRepository.findById(((Double)request.get("messageId")).intValue()).get();
        sourceDevice.setMessage(message);
        SourceType type = sourceTypeRepository.findById(((Double)request.get("sourceTypeId")).intValue()).get();
        sourceDevice.setSourceType(type);
        sourceDeviceRepository.save(sourceDevice);
    }

    public void deleteSource(Map request){
        String sourceId = (String)request.get("sourceId");
        sourceDeviceRepository.deleteById(sourceId);
    }
}
