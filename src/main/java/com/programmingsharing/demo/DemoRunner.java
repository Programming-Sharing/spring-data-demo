package com.programmingsharing.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.programmingsharing.demo.domain.Comment;

@Component
@Order(2)
public class DemoRunner implements CommandLineRunner{

	private MongoTemplate mongoTemplate;

    public DemoRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	@Override
	public void run(String... args) throws Exception {
		
		Query query = Query.query(Criteria.where("message").is("Great."));
		Comment existingCmt = mongoTemplate.findOne(query, Comment.class);
		
		existingCmt.setMessage("Updated comment");
		
		// Replace the existing document with a completely document
		mongoTemplate.save(existingCmt);
		
		
		// Save an existing document will be insert as a new document
		mongoTemplate.save(new Comment("Inserted by save method"));
		
		// Using updateFirst or updateMulti to update documents returned by a query
		Query firstGreatCmts = Query.query(Criteria.where("message").is("Great."));
		mongoTemplate.updateFirst(firstGreatCmts, Update.update("message", "This comment updated by updateFirst methods"), Comment.class);
		
		// Batch update
		Query greatCmtsRemaining = Query.query(Criteria.where("message").is("Great."));
		mongoTemplate.updateMulti(greatCmtsRemaining, Update.update("newField", "New field added by updateMulti method"), Comment.class);
				
	}
	
}
