package com.pushbutton.services;

import com.pushbutton.Exceptions.ArgumentNotFoundException;
import com.pushbutton.models.Phone;
import com.pushbutton.models.SourceDevice;
import com.pushbutton.repositories.SourceDeviceRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SourceDeviceService {

    @Value("${firebase.key}")
    String firebaseKey;
    @Value("${firebase.url}")
    String firebaseUrl;

    @Autowired
    private SourceDeviceRepository sourceDeviceRepository;

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
}
