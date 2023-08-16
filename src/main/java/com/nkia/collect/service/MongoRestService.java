package com.nkia.collect.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;

import java.util.List;

public interface MongoRestService {

    public InsertOneResult insertOne(String collectionName, Document document);
    public InsertManyResult insertMany(String collectionName, List<Document> documents);
    public FindIterable<Document> find(String collectionName);
    public JSONArray findByQuery(String collectionName, String fromDate, String toDate);
    public Document findById(String collectionName, String id);
    public UpdateResult updateOne(String collectionName, String id, Bson update);
    public UpdateResult updateMany(String collectionName, Bson query, Bson updates);
    public DeleteResult deleteOne(String collectionName, String id);
    public DeleteResult deleteMany(String collectionName, Bson query);

}
