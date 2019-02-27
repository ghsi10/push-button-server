package com.pushbutton.services;

import com.pushbutton.Exceptions.ArgumentNotFoundException;
import com.pushbutton.Exceptions.ConnectionException;
import com.pushbutton.models.Phone;
import com.pushbutton.models.SourceDevice;
import com.pushbutton.repositories.SourceDeviceRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
            data.put("MessageId", sourceDevice.getMessage().getAudio() ? sourceDevice.getMessage().getId() : -1);
            JSONObject notification = new JSONObject();
            notification.put("text", "New notification");
            JSONObject json = new JSONObject();
            json.put("data", data);
            json.put("notification", notification);
            json.put("to", phone.getToken());
            HttpEntity<String> httpEntity = new HttpEntity<>(json.toString(), httpHeaders);
            if (restTemplate.postForEntity(firebaseUrl, httpEntity, Object.class).getStatusCode() != HttpStatus.OK)
                System.out.println("problem!"); // TODO add to log
        }
    }
}
