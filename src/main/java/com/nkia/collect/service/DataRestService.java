package com.nkia.collect.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/datas")
public class DataRestService {

    private static final String KEY_LINE = "line";
    private static final String KEY_PEDESTRIAN = "pedestrian";
    private static final String KEY_FRONT = "front";
    private static final String KEY_DANGER = "danger";
    private static final String KEY_CONDITION = "condition";

    @Autowired
    SearchService searchService;

    @PostMapping("/cits")
    public String getCits(@RequestParam Map<String, String> searchKeys) {

        JSONArray jsonArray = new JSONArray();

        boolean lineKey = Boolean.parseBoolean(searchKeys.get("lineKey"));
        boolean frontKey = Boolean.parseBoolean(searchKeys.get("frontKey"));
        boolean conditionKey = Boolean.parseBoolean(searchKeys.get("conditionKey"));
        boolean dangerKey = Boolean.parseBoolean(searchKeys.get("dangerKey"));
        boolean pedestrianKey = Boolean.parseBoolean(searchKeys.get("pedestrianKey"));
        
        //if문을 사용해서 모든 선택된 키에 대해 검색을 할 수 있도록.
        if (lineKey) {
            jsonArray.put(searchService.getLineData(searchKeys));
        }
        if (frontKey) {
            jsonArray.put(searchService.getFrontData(searchKeys));
        }
        if (conditionKey) {
            jsonArray.put(searchService.getConditionData(searchKeys)); 
        }
        if (dangerKey) {
            jsonArray.put(searchService.getDangerData(searchKeys)); 
        }
        if (pedestrianKey) {
            jsonArray.put(searchService.getPedestrianData(searchKeys));
        }

        return jsonArray.toString();
    }
}