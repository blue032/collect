package com.nkia.collect.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE = "sjkim";  // 각자 이름

    @Bean
    public MongoDatabase mongoDatabase() {
        MongoClient mongoClient = MongoClients.create(URI);
        MongoDatabase database = mongoClient.getDatabase(DATABASE);
        return database;
    }

}
