package com.nkia.collect.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080") // 추가
@RestController
@RequestMapping("/datas")
public class DataRestService {

    private static final String KEY_LINE = "line";
    private static final String KEY_PEDESTRIAN = "pedestrian";
    private static final String KEY_FRONT = "front";

    @Autowired
    SearchService searchService;

    // key : lineKey, frontKey, conditionKey ~~ 5개
    // key : fromDate, toDate
    @PostMapping("/cits")
    public String getCits(@RequestParam Map<String, String> searchKeys) {
        JSONArray jsonArray =  new JSONArray();
        boolean lineKey = Boolean.parseBoolean(searchKeys.get("lineKey"));
        boolean frontKey = Boolean.parseBoolean(searchKeys.get("frontKey"));

        if(lineKey ==  true) {
            jsonArray.put(searchService.getLineData(searchKeys));
        } else if(frontKey == true) {
            //jsonArray.put(searchService.getFrontData(searchKeys));
        }

        return jsonArray.toString();
    }

}
