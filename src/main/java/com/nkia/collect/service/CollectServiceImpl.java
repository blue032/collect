//CollectServicelmpl 클래스
//api를 연결해서 데이터를 MongoDB에 저장

package com.nkia.collect.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Map;

@Service
public class CollectServiceImpl implements CollectService {

    private final MongoRestService mongoRestservice;
    private final MongoTemplate mongoTemplate;

    public CollectServiceImpl(MongoRestService mongoRestservice, MongoTemplate mongoTemplate) {
        this.mongoRestservice = mongoRestservice;
        this.mongoTemplate = mongoTemplate;  // 생성자에서 전달받은 mongoTemplate 인스턴스를 할당
    }
    @Override
    public String getApiDate() {



        // 보행자

        UriComponents uriComponents1 //보행자 충돌 주의
                = UriComponentsBuilder.fromUriString("https://t-data.seoul.go.kr/apig/apiman-gateway/tapi/v2xPedestrianCollisionWarning/1.0")
                .queryParam("apiKey", "17c13c08-e07c-4169-acab-2480aeccfcbd")
                .queryParam("type", "json")
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 1000)
                .build(true);

        UriComponents uriComponents2 //차선이탈
                = UriComponentsBuilder.fromUriString("https://t-data.seoul.go.kr/apig/apiman-gateway/tapi/v2xLaneDepartureWarning/1.0")
                .queryParam("apiKey", "86e683fe-df10-4e49-8632-68e4663dc681")
                .queryParam("type", "json")
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 1000)
                .build(true);

        UriComponents uriComponents3 //전방추돌
                = UriComponentsBuilder.fromUriString("https://t-data.seoul.go.kr/apig/apiman-gateway/tapi/v2xForwardCollisionWarning")
                .queryParam("apiKey", "86e683fe-df10-4e49-8632-68e4663dc681")
                .queryParam("type", "json")
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 1000)
                .build(true);

        UriComponents uriComponents4 //위험구간
                = UriComponentsBuilder.fromUriString("https://t-data.seoul.go.kr/apig/apiman-gateway/tapi/v2xRiskAreaInformation/1.0")
                .queryParam("apiKey", "86e683fe-df10-4e49-8632-68e4663dc681")
                .queryParam("type", "json")
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 1000)
                .build(true);

        UriComponents uriComponents5 //차량상태
                = UriComponentsBuilder.fromUriString("https://t-data.seoul.go.kr/apig/apiman-gateway/tapi/v2xVehiclesStatusInformation/1.0")
                .queryParam("apiKey", "86e683fe-df10-4e49-8632-68e4663dc681")
                .queryParam("type", "json")
                .queryParam("pageNo", 1)
                .queryParam("numOfRows", 1000)
                .build(true);

        String apiData1 = RestUtil.getData(uriComponents1.toUriString());
        String apiData2 = RestUtil.getData(uriComponents2.toUriString());
        String apiData3 = RestUtil.getData(uriComponents3.toUriString());
        String apiData4 = RestUtil.getData(uriComponents4.toUriString());
        String apiData5 = RestUtil.getData(uriComponents5.toUriString());

        // JSONObject를 사용하여 데이터를 MongoDB에 저장
        JSONObject json1 = new JSONObject(apiData1);
        mongoTemplate.save(json1.toString(), "ApiDataCollection");

        JSONObject json2 = new JSONObject(apiData2);
        mongoTemplate.save(json2.toString(), "ApiDataCollection");

        JSONObject json3 = new JSONObject(apiData3);
        mongoTemplate.save(json3.toString(), "ApiDataCollection");

        JSONObject json4 = new JSONObject(apiData4);
        mongoTemplate.save(json4.toString(), "ApiDataCollection");

        JSONObject json5 = new JSONObject(apiData5);
        return mongoTemplate.save(json5.toString(), "ApiDataCollection");

    }
}