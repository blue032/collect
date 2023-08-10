package com.nkia.collect.service;

import com.mongodb.client.*;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static org.junit.jupiter.api.Assertions.*;

class MongoRestServiceImplTest {

    static MongoDatabase database;

    @BeforeAll
    static void beforeAll(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("sjkimtest");
    }

    @Test
    @DisplayName("insert 테스트")
    void insertOne() {
        Document document = new Document("test", "test");
        MongoCollection<Document> collection = database.getCollection("test");
        InsertOneResult result = collection.insertOne(document);
        assertTrue(result.getInsertedId() != null);
    }

    @Test
    @DisplayName("insertMany 테스트")
    void insertMany() {
        MongoCollection<Document> collection = database.getCollection("test");
        List<Document> documents = new ArrayList<>();
        Document document = new Document("admin", "admin");
        documents.add(document);
        document = new Document("test", "test2");
        documents.add(document);

        InsertManyResult result = collection.insertMany(documents);
        assertTrue(result.getInsertedIds() != null);
    }

    @Test
    void find() {
        MongoCollection<Document> collection = database.getCollection("test");
        collection.find();
        assertTrue(collection.find() != null);
    }

    @Test
    void findById() {
        MongoCollection<Document> collection = database.getCollection("test");
//        FindIterable<Document> results = collection.find();
//        Document document = results.first();
//        String id = document.get("_id").toString();

        Document result = collection.find(eq("admin", "admin")).first();

        assertTrue(result != null);
    }

    @Test
    void updateOne() {
        MongoCollection<Document> collection = database.getCollection("test");
        FindIterable<Document> results = collection.find();
        Document document = results.first();
        String id = document.get("_id").toString();

        Bson query = eq("_id", new ObjectId(id));
        Bson update = Updates.combine(
                Updates.set("test", "test_update"));

        UpdateResult result = collection.updateOne(query, update);

        assertTrue(result != null);
    }

    @Test
    void updateMany() {
        MongoCollection<Document> collection = database.getCollection("test");
        FindIterable<Document> results = collection.find();
        Iterator<Document> it = results.iterator();

        List<ObjectId> ids = new ArrayList<>();
        while(it.hasNext()) {
            ids.add(new ObjectId(it.next().get("_id").toString()));
        }
        Bson query = in("_id", ids);
        Bson update = Updates.combine(
                Updates.set("test", "test_update_many"));

        UpdateResult result = collection.updateMany(query, update);
        assertTrue(result != null);

    }

    @Test
    void deleteOne() {
        MongoCollection<Document> collection = database.getCollection("test");
        FindIterable<Document> results = collection.find();
        Document document = results.first();

        String id = document.get("_id").toString();
        Bson query = eq("_id", new ObjectId(id));

        DeleteResult result = collection.deleteOne(query);
        assertTrue(result != null);
    }

    @Test
    void deleteMany() {
        MongoCollection<Document> collection = database.getCollection("test");
        FindIterable<Document> results = collection.find();
        Iterator<Document> it = results.iterator();

        List<ObjectId> ids = new ArrayList<>();
        while(it.hasNext()) {
            ids.add(new ObjectId(it.next().get("_id").toString()));
        }
        Bson query = in("_id", ids);

        DeleteResult result = collection.deleteMany(query);
        assertTrue(result != null);
    }
}