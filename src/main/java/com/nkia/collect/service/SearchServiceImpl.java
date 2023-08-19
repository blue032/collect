package com.nkia.collect.service;

import com.mongodb.client.FindIterable;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    private static final  String COLLECTION_LINE = "line";
    private static final  String COLLECTION_FRONT = "front";
    private static final  String COLLECTION_CONDITION = "condition";
    private static final  String COLLECTION_DANGER = "danger";
    private static final  String COLLECTION_PEDESTRIAN= "pedestrian";


    @Autowired
    MongoRestService mongoRestService;

    public JSONArray getLineData(Map<String, String> searchKeys) {

        String fromDate = searchKeys.get("fromDate");
        String toDate = searchKeys.get("toDate");
        String time = searchKeys.get("time");

        return mongoRestService.findByQuery(COLLECTION_LINE, fromDate, toDate, time);

    }
    
    public JSONArray getFrontData(Map<String, String> searchKeys) {

        String fromDate = searchKeys.get("fromDate");
        String toDate = searchKeys.get("toDate");
        String time = searchKeys.get("time");

        return mongoRestService.findByQuery(COLLECTION_FRONT, fromDate, toDate, time);

    }
    
    public JSONArray getConditionData(Map<String, String> searchKeys) {

        String fromDate = searchKeys.get("fromDate");
        String toDate = searchKeys.get("toDate");
        String time = searchKeys.get("time");

        return mongoRestService.findByQuery(COLLECTION_CONDITION, fromDate, toDate, time);

    }
    
    @Override
    public JSONArray getDangerData(Map<String, String> searchKeys) {
        String fromDate = searchKeys.get("fromDate");
        String toDate = searchKeys.get("toDate");
        String time = searchKeys.get("time");

        return mongoRestService.findByQuery(COLLECTION_DANGER, fromDate, toDate, time);
    }
    
    public JSONArray getPedestrianData(Map<String, String> searchKeys) {

        String fromDate = searchKeys.get("fromDate");
        String toDate = searchKeys.get("toDate");
        String time = searchKeys.get("time");

        return mongoRestService.findByQuery(COLLECTION_PEDESTRIAN, fromDate, toDate, time);

    }
}