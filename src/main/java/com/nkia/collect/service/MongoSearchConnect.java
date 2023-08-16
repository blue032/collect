package com.nkia.collect.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.nkia.collect.model.Line;
import com.nkia.collect.model.Pedestrian;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MongoSearchConnect {

    private final MongoDatabase mongoDatabase;

    @Autowired
    public MongoSearchConnect(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

//    public ArrayList<Pedestrian> selectListData() { //보행자
//        try {
//            // Assuming you have a 'Member' class
//            MongoCollection<Document> collection = mongoDatabase.getCollection("your_collection_name");
//
//            // 전체 조회하기, 정렬을 _id 오름차순
//            FindIterable<Document> docs = collection.find().sort(Filters.eq("_id", 1));
//
//            ArrayList<pedestrian> list = new ArrayList<>();
//
//            for (Document tmp : docs) { //tep이거 수정하기 /pedestrian클래스 만들어주기(각 해당하는 데이터들에 대해서), 날짜별로 나오도록 수정.
//            	pedestrian pedestrianMember = new pedestrian();
//            	pedestrianMember.setTrsmYear(tmp.getString("trsmyear"));
//            	pedestrianMember.setTrsmMt(tmp.getString("trsmmt"));
//            	pedestrianMember.setTrsmDy(tmp.getInteger("trsmdy"));
//            	pedestrianMember.setVhcleLot(tmp.getString("vhclelot"));
//            	pedestrianMember.setVhcleLAtIdws(tmp.getString("vhclelatidws"));
//            	pedestrianMember.setPcws(tmp.getString("pcws"));
//
//                list.add(pedestrianMember);
//            }
//            return list;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ArrayList<Line> selectListData() {//차선이탈
//        try {
//            // Assuming you have a 'Member' class
//            MongoCollection<Document> collection = mongoDatabase.getCollection("your_collection_name");
//
//            // 전체 조회하기, 정렬을 _id 오름차순
//            FindIterable<Document> docs = collection.find().sort(Filters.eq("_id", 1));
//
//            ArrayList<line> list = new ArrayList<>();
//
//            for (Document tmp : docs) { //pedestrian클래스 만들어주기(각 해당하는 데이터들에 대해서), 날짜별로 나오도록 수정.
//            	line lineMember = new line();
//            	lineMember.setTrsmYear(tmp.getString("trsmyear"));
//            	lineMember.setTrsmMt(tmp.getString("trsmmt"));
//            	lineMember.setTrsmDy(tmp.getInteger("trsmdy"));
//            	lineMember.setVhcleLot(tmp.getString("vhclelot"));
//            	lineMember.setVhcleLAtIdws(tmp.getString("vhclelatidws"));
//            	lineMember.setPcws(tmp.getString("pcws"));
//
//                list.add(lineMember);
//            }
//            return list;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ArrayList<front> selectListData() {//전방추돌
//        try {
//            // Assuming you have a 'Member' class
//            MongoCollection<Document> collection = mongoDatabase.getCollection("your_collection_name");
//
//            // 전체 조회하기, 정렬을 _id 오름차순
//            FindIterable<Document> docs = collection.find().sort(Filters.eq("_id", 1));
//
//            ArrayList<front> list = new ArrayList<>();
//
//            for (Document tmp : docs) { //pedestrian클래스 만들어주기(각 해당하는 데이터들에 대해서), 날짜별로 나오도록 수정.
//            	front frontMember = new front();
//            	frontMember.setTrsmYear(tmp.getString("trsmyear"));
//            	frontMember.setTrsmMt(tmp.getString("trsmmt"));
//            	frontMember.setTrsmDy(tmp.getInteger("trsmdy"));
//            	frontMember.setVhcleLot(tmp.getString("vhclelot"));
//            	frontMember.setVhcleLAtIdws(tmp.getString("vhclelatidws"));
//            	frontMember.setPcws(tmp.getString("pcws"));
//
//                list.add(frontMember);
//            }
//            return list;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ArrayList<danger> selectListData() {//위험구간
//        try {
//            // Assuming you have a 'Member' class
//            MongoCollection<Document> collection = mongoDatabase.getCollection("your_collection_name");
//
//            // 전체 조회하기, 정렬을 _id 오름차순
//            FindIterable<Document> docs = collection.find().sort(Filters.eq("_id", 1));
//
//            ArrayList<danger> list = new ArrayList<>();
//
//            for (Document tmp : docs) { //pedestrian클래스 만들어주기(각 해당하는 데이터들에 대해서), 날짜별로 나오도록 수정.
//            	danger dangerMember = new danger();
//            	dangerMember.setItisCd(tmp.getString("itiscd"));
//            	dangerMember.setTrsmYear(tmp.getString("trsmyear"));
//            	dangerMember.setTrsmMt(tmp.getString("trsmmt"));
//            	dangerMember.setTrsmDy(tmp.getInteger("trsmdy"));
//            	dangerMember.setDetclot(tmp.getString("detclot"));
//            	dangerMember.setDetclat(tmp.getString("detclat"));
//
//
//                list.add(dangerMember);
//            }
//            return list;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public ArrayList<condition> selectListData() {//위험구간
//        try {
//            // Assuming you have a 'Member' class
//            MongoCollection<Document> collection = mongoDatabase.getCollection("your_collection_name");
//
//            // 전체 조회하기, 정렬을 _id 오름차순
//            FindIterable<Document> docs = collection.find().sort(Filters.eq("_id", 1));
//
//            ArrayList<condition> list = new ArrayList<>();
//
//            for (Document tmp : docs) { //pedestrian클래스 만들어주기(각 해당하는 데이터들에 대해서), 날짜별로 나오도록 수정.
//            	condition conditionMember = new condition();
//            	conditionMember.setTrsmYear(tmp.getString("trsmyear"));
//            	conditionMember.setTrsmMt(tmp.getString("trsmmt"));
//            	conditionMember.setTrsmDy(tmp.getInteger("trsmdy"));
//            	conditionMember.setVhcleLot(tmp.getString("vhclelot"));
//            	conditionMember.setVhcleLAtIdws(tmp.getString("vhclelatidws"));
//            	conditionMember.setPcws(tmp.getString("pcws"));
//
//                list.add(conditionMember);
//            }
//            return list;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}