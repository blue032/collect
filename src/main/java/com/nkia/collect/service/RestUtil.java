package com.nkia.collect.service;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtil {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static String getData(String url) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        return response.getBody();
    }
}
