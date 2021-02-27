package com.programmingsharing.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.programmingsharing.demo.domain.Message;

@Component
public class DemoRunner implements CommandLineRunner{

	private MongoTemplate mongoTemplate;

    public DemoRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        Message emptyFlight = new Message("David", "Thomas", "Welcome to ProgrammingSharing.com");
        this.mongoTemplate.save(emptyFlight);

        System.out.println("Application started...");
    }

}
