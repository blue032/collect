package com.nkia.collect.service;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RestServiceImplTest {

    @Test
    void getData() {

        UriComponents uriComponents
                = UriComponentsBuilder.fromUriString("https://t-data.seoul.go.kr/apig/apiman-gateway/tapi/v2xPedestrianCollisionWarning/1.0")
                .queryParam("apiKey", "17c13c08-e07c-4169-acab-2480aeccfcbd")
                .queryParam("type", "json")
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 1000)
                .build(true);

        String json = RestUtil.getData(uriComponents.toUriString());

        assertTrue(json != null);
    }
}