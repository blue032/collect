package com.nkia.collect.service;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CollectServiceImpl implements CollectService {

    private final MongoRestService mongoRestservice;

    public CollectServiceImpl(MongoRestService mongoRestservice) {
        this.mongoRestservice = mongoRestservice;
    }

    @Override
    public String getApiDate() {

        UriComponents uriComponents
                = UriComponentsBuilder.fromUriString("https://t-data.seoul.go.kr/apig/apiman-gateway/tapi/v2xPedestrianCollisionWarning/1.0")
                .queryParam("apiKey", "17c13c08-e07c-4169-acab-2480aeccfcbd")
                .queryParam("type", "json")
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 1000)
                .build(true);

        String result = RestUtil.getData(uriComponents.toUriString());

        return result;
    }
}
