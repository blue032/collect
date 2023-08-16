//MongoConfig 클래스

package com.nkia.collect.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    private static final String URI = "mongodb+srv://jihyeon4036:qpqpqp1212%40%40@cluster0.mnm7wem.mongodb.net/";
    private static final String DATABASE = "test";  // 공통데이터베이스로 수정

    @Bean
    public MongoDatabase mongoDatabase() {
        MongoClient mongoClient = MongoClients.create(URI);
        MongoDatabase database = mongoClient.getDatabase(DATABASE);
        return database;
    }

}
