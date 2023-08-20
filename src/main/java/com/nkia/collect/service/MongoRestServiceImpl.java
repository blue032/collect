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
import lombok.Getter;
import lombok.Setter;
@Getter@Setter
@Service //컨트롤러, 리포지토리에서 사용 가능
public class MongoRestServiceImpl implements MongoRestService {
	
    private final MongoDatabase mongoDatabase; //생성자를 통해 mongoDatabase 객체 주입받음
    
    
    public MongoRestServiceImpl(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase; //생성자를 통해 mongoDatabase 객체 주입받음
    }

    @Override
    public InsertOneResult insertOne(String collectionName, Document document) { //단일문서 지정된 컬렉션에 삽입
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName); 
        return collection.insertOne(document);
    }

    @Override
    public InsertManyResult insertMany(String collectionName, List<Document> documents) { //여러 문서를 지정된 컬렉션에 삽입
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection.insertMany(documents);
    }

    @Override
    public FindIterable<Document> find(String collectionName) { //지정된 컬렉션에서 모든 문서 검색
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection.find();
    }
    //특정 쿼리 조건에 따라 문서 검색
    @Override
    public JSONArray findByQuery(String collectionName, String fromDate, String toDate, String time) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName); //몽고디비의 컬렉션 얻어옴
        

        
        int year = 2023; // 원하는 연도를 설정
        int month = 8;   // 원하는 월을 설정

        //filter라는 비슨객체 생성, 몽고디비 쿼리 구성하는 데 사용
        Bson filter = Filters.and(Filters.gte("trsmDy", Integer.parseInt(fromDate)), // start just after our last position
                Filters.lt("trsmDy", Integer.parseInt(toDate))); //trsmDy가 fromDatez(gte)이상 ~ toDate 미만(lt)

        //time 값이 비어있지 않으면
        if(time != null && !time.isEmpty()) {
            filter = Filters.and(Filters.gte("trsmDy", Integer.parseInt(fromDate)), // start just after our last position
                    Filters.lte("trsmDy", Integer.parseInt(toDate))
                    ,Filters.gte("trsmTm", time+"0000") // 예)10시 00 00초 ~ 10시 59분 59초
                    , Filters.lte("trsmTm", time+"5959")
            );
        }
        
       //if문으로 차선이탈일 때 날짜 검색 시 Common클래스에 있는 데이터 가져오기
        if (collectionName.equals("COLLECTION_LINE")) {
            filter = Filters.and(
                Filters.eq("trsmDy", String.valueOf(dd)),
                Filters.eq("vhcleLot", common.getVhcleLot()),
                Filters.eq("vhcleLat", common.getVhcleLat()),
                Filters.eq("ldws", common.getLdws()),    
                Filters.eq("pcws", common.getPcws())
                
               
            );
        }
        if (collectionName.equals("COLLECTION_CONDITION")) {
            filter = Filters.and(
                Filters.eq("trsmDy", String.valueOf(dd)),
                Filters.eq("vhcleLot", common.getVhcleLot()),
                Filters.eq("vhcleLat", common.getVhcleLat()),
                Filters.eq("ldws", common.getLdws()),     
                Filters.eq("pcws", common.getPcws())   
               
            );
        }
        if (collectionName.equals("COLLECTION_FRONT")) {
            filter = Filters.and(
                Filters.eq("trsmDy", String.valueOf(dd)),
                Filters.eq("vhcleLot", common.getVhcleLot()),
                Filters.eq("vhcleLat", common.getVhcleLat()),
                Filters.eq("ldws", common.getLdws()),     
                Filters.eq("pcws", common.getPcws())
               
            );
        }
        if (collectionName.equals("COLLECTION_PESTRIAN")) {
            filter = Filters.and(
                Filters.eq("trsmDy", String.valueOf(dd)),
                Filters.eq("vhcleLot", common.getVhcleLot()),
                Filters.eq("vhcleLat", common.getVhcleLat()),
                Filters.eq("ldws", common.getLdws()),     
                Filters.eq("pcws", common.getPcws())

               
            );
        }
        if (collectionName.equals("COLLECTION_DANGER")) {
            filter = Filters.and(
                Filters.eq("trsmDy", String.valueOf(dd)),
                Filters.eq("ldws", common.getLdws()),    
                Filters.eq("pcws", common.getPcws()),
                Filters.eq("detcLot", danger.getDetcLot()),
                Filters.eq("detcLat", danger.getDetcLat()),
                Filters.eq("itisCd", danger.getItisCd()) 

            );
        }
    }
        
        FindIterable<Document> result = collection.find(filter); //위에서 정의한 filter 사용하여 문서 검색
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
