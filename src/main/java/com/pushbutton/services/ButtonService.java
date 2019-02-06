package com.pushbutton.services;

import com.pushbutton.Exceptions.ArgumentNotFoundException;
import com.pushbutton.Exceptions.ConnectionException;
import com.pushbutton.models.Button;
import com.pushbutton.repositories.ButtonRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.net.ConnectionResetException;

@Service
public class ButtonService {

    @Value("${firebase.key}")
    String firebaseKey;
    @Value("${firebase.url}")
    String firebaseUrl;

    @Autowired
    private ButtonRepository buttonRepository;

    public void clickButton(Long id) throws ArgumentNotFoundException, ConnectionException {
        // TODO check it!
        RestTemplate restTemplate = new RestTemplate();

        Button button = buttonRepository.findById(id).orElseThrow(ArgumentNotFoundException::new);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "key=" + firebaseKey);
        httpHeaders.set("Content-Type", "application/json");

        JSONObject msg = new JSONObject();
        JSONObject json = new JSONObject();

        msg.put("title", "new message");
        msg.put("body", button.getMessage());

        json.put("data", msg);
        json.put("to", button.getPhone().getToken());

        HttpEntity<String> httpEntity = new HttpEntity<>(json.toString(), httpHeaders);
        if (restTemplate.postForEntity(firebaseUrl, httpEntity, Object.class).getStatusCode() != HttpStatus.OK)
            throw new ConnectionException();
    }
}
