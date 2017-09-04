package com.bob.conf;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;



@Configuration
//@EnableMongoRepositories("com.tbox")                                     
public class MongoCof /*extends AbstractMongoConfiguration*/{
/*
	@Override
	protected String getDatabaseName() {
		return "sdea";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("192.168.1.117");
		
	}

*/
	
}
