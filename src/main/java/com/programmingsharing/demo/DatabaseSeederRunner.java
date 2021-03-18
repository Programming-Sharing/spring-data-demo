package com.programmingsharing.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.programmingsharing.demo.domain.Comment;

/**
 * This runner will be ran first to initialize the seed data that allow us to run the DemoRunner
 * @author tranthanhdeveloper@gmail.com
 *
 */
@Component
@Order(1)
public class DatabaseSeederRunner implements CommandLineRunner{
	
	private MongoTemplate mongoTemplate;
	
	public DatabaseSeederRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

	@Override
	public void run(String... args) throws Exception {
		dropCollection("comment");
		initSeed();
		
	}

	private void initSeed() {
		Comment cmt1 = new Comment("Thank you for informative article.");
		Comment cmt2 = new Comment("Great.");
		Comment cmt3 = new Comment("Great.");
		Comment cmt4 = new Comment("Great.");
		Comment cmt5 = new Comment("Great.");
		
		Comment cmt6 = new Comment("Thank for sharing");		
		Comment cmt7 = new Comment("Thank you for informative article.");
		List<Comment> cmts = Arrays.asList(cmt1, cmt2, cmt3, cmt4, cmt5, cmt6, cmt7);	
		mongoTemplate.insertAll(cmts);
		
	}

	private void dropCollection(String collectionName) {
		this.mongoTemplate.dropCollection(collectionName);
		
	}

}
