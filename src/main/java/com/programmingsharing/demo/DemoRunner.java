package com.programmingsharing.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.programmingsharing.demo.domain.Comment;

@Component
public class DemoRunner implements CommandLineRunner{

	private MongoTemplate mongoTemplate;

    public DemoRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
	
	@Override
	public void run(String... args) throws Exception {
		
		Comment cmt = new Comment("Thank you for informative article.");
		
		// insert single document
		mongoTemplate.insert(cmt);
		
		
		
		Comment cmt1 = new Comment("Thank you for informative article.");
		Comment cmt2 = new Comment("Great.");
		Comment cmt3 = new Comment("Thank for sharing");
		Comment cmt4 = new Comment("Thank you for informative article.");

		List<Comment> cmts = Arrays.asList(cmt1, cmt2, cmt3, cmt4);
		
		// Insert multiple documents - Batch insert
		mongoTemplate.insertAll(cmts);
	}
	
}
