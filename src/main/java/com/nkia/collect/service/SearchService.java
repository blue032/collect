package com.nkia.collect.service;

import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public interface SearchService {

	//여기 수정했음
    public JSONArray getLineData(Map<String, String> searchKeys);
    public JSONArray getFrontData(Map<String, String> searchKeys);
    public JSONArray getConditionData(Map<String, String> searchKeys);
    public JSONArray getDangerData(Map<String, String> searchKeys);
    public JSONArray getPedestrianData(Map<String, String> searchKeys);

}
