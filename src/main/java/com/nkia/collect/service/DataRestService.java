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
    private static final String KEY_FRONT = "front"; //이것도 5개 만들어주기
    private static final String KEY_DANGER = "danger";
    private static final String KEY_CONDITION = "condition";

    @Autowired
    SearchService searchService;

    // key : lineKey, frontKey, conditionKey ~~ 5개
    // key : fromDate, toDate
    @PostMapping("/cits")
    public String getCits(@RequestParam Map<String, String> searchKeys) {

        System.out.println(searchKeys.toString());

        JSONArray jsonArray =  new JSONArray();
        //boolean안이 체크박스 선택하는거 그래서 5개 만들기

        boolean lineKey = Boolean.parseBoolean(searchKeys.get("lineKey"));
        boolean frontKey = Boolean.parseBoolean(searchKeys.get("frontKey"));
        boolean conditiontKey = Boolean.parseBoolean(searchKeys.get("conditionKey"));
        boolean dangerKey = Boolean.parseBoolean(searchKeys.get("dangerKey"));
        boolean pestriangiKey = Boolean.parseBoolean(searchKeys.get("pedestrianKey"));

        //여기 수정했음
        if(lineKey ==  true) {
            jsonArray.put(searchService.getLineData(searchKeys));
        } /*else if(frontKey == true) {
            jsonArray.put(searchService.getFrontData(searchKeys)); //FrontData 만들어야함
        }else if (conditionKey == true) {
        	jsonArray.put(searchService.getconditionData(searchKeys)); //conditionData 만들어야함
        }else if (dangerKey == true) {
        	jsonArray.put(searchService.getdangerData(searchKeys)); //dangerData 만들어야함.
        }else if (pedestrianKey == true) {
        	jsonArray.put(searchService.getpedestrianData(searchKeys)); //pedestrianData만들어함
        }*/

        System.out.println(jsonArray.toString());

        return jsonArray.toString();
    }

}
