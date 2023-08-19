//몽고디비와 상호작용하는 MongoRestServiceImpl 클래스에서 구현해야 하는 메소드 정의 
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

    public InsertOneResult insertOne(String collectionName, Document document); //단일 문서를 지정된 컬렉션에 삽입하는 메서드. 컬렉션, 삽입할 다큐먼트 객체 전달
    public InsertManyResult insertMany(String collectionName, List<Document> documents); //여러 문서를 지정된 컬렉션에 삽입하는 메소드. 
    public FindIterable<Document> find(String collectionName); //지정된 컬렉션에서 모든 문서 검색하는 메소드
    public JSONArray findByQuery(String collectionName, String fromDate, String toDate, String time); //조건에 따라 문서 검색하는 메소드
    public Document findById(String collectionName, String id); //지정된 ID로 검색하는 메소드. 
    public UpdateResult updateOne(String collectionName, String id, Bson update); //지정된 ID에 해당하는 문서를 업데이트하는 메소드
    public UpdateResult updateMany(String collectionName, Bson query, Bson updates); //지정된 조건에 따라 여러 문서 업데이트 하는 메소드. 쿼리: 업뎃할 조건, updates: 업뎃내용전달
    public DeleteResult deleteOne(String collectionName, String id); //지정된 ID에 해당하는 문서 삭제
    public DeleteResult deleteMany(String collectionName, Bson query); //지정된 조건에 따라 문서 삭제

}
