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

        System.out.println(searchKeys.toString());

        JSONArray jsonArray = new JSONArray();

        boolean lineKey = Boolean.parseBoolean(searchKeys.get("lineKey"));
        boolean frontKey = Boolean.parseBoolean(searchKeys.get("frontKey"));
        boolean conditionKey = Boolean.parseBoolean(searchKeys.get("conditionKey"));
        boolean dangerKey = Boolean.parseBoolean(searchKeys.get("dangerKey"));
        boolean pedestrianKey = Boolean.parseBoolean(searchKeys.get("pedestrianKey"));
        
        //if문을 사용해서 모든 선택된 키에 대해 검색을 할 수 있도록.
        if (lineKey) {
            jsonArray.put(searchService.getLineData(searchKeys));
<<<<<<< HEAD
        } else if(frontKey == true) {
            jsonArray.put(searchService.getFrontData(searchKeys)); //FrontData 만들어야함
        }else if (conditionKey == true) {
        	jsonArray.put(searchService.getconditionData(searchKeys)); //conditionData 만들어야함
        }else if (dangerKey == true) {
        	jsonArray.put(searchService.getdangerData(searchKeys)); //dangerData 만들어야함.
        }else if (pedestrianKey == true) {
        	jsonArray.put(searchService.getpedestrianData(searchKeys)); //pedestrianData만들어함
=======
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
>>>>>>> ef84d236b06ab1a4f5615d1357e4cd30f2163b94
        }

        System.out.println(jsonArray.toString());

        return jsonArray.toString();
    }
}