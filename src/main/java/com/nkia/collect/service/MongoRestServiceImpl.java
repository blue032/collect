package com.nkia.collect.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mongodb.client.model.Filters.*;

@Service
public class MongoRestServiceImpl implements MongoRestService {

    private final MongoDatabase mongoDatabase;

    public MongoRestServiceImpl(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    @Override
    public InsertOneResult insertOne(String collectionName, Document document) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection.insertOne(document);
    }

    @Override
    public InsertManyResult insertMany(String collectionName, List<Document> documents) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection.insertMany(documents);
    }

    @Override
    public FindIterable<Document> find(String collectionName) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection.find();
    }

    @Override
    public JSONArray findByQuery(String collectionName, String fromDate, String toDate) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        Bson filter = Filters.and(Filters.gte("trsmDy", Integer.parseInt(fromDate)), // start just after our last position
                Filters.lt("trsmDy", Integer.parseInt(toDate)));
        FindIterable<Document> result = collection.find(filter);
        JSONArray array = new JSONArray();
        for(Document d : result) {
            array.put(new JSONObject(d.toJson()));
        }
        return array;
    }

    @Override
    public Document findById(String collectionName, String id) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public UpdateResult updateOne(String collectionName, String id, Bson update) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        Bson query = eq("_id", new ObjectId(id));
        return collection.updateOne(query, update);
    }

    @Override
    public UpdateResult updateMany(String collectionName, Bson query, Bson updates) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection.updateMany(query, updates);
    }

    @Override
    public DeleteResult deleteOne(String collectionName, String id) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        Bson query = eq("_id", new ObjectId(id));
        return collection.deleteOne(query);
    }

    @Override
    public DeleteResult deleteMany(String collectionName, Bson query) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection.deleteOne(query);
    }


}
