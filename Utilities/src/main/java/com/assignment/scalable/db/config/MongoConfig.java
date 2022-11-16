package com.assignment.scalable.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.assignment.scalable.db.utils.MongoConstants;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

@Configuration
public class MongoConfig {
	public static final String USERNAME = "root";
	public static final String PASSWORD = "password";
	public static final String HOSTNAME = "localhost";
	public static final String AUTH_DATABASE = "admin";
	public static final Integer PORT = 27017;

	@Bean(destroyMethod = "close")
	public MongoClient getMongoClient() {
		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(10).socketTimeout(10000)
				.maxWaitTime(10000).connectTimeout(10000).build();
//		MongoCredential credential = MongoCredential.createCredential(USERNAME, AUTH_DATABASE, PASSWORD.toCharArray());
//		MongoClient mongoClient = new MongoClient(new ServerAddress(HOSTNAME, PORT), credential, options);

		MongoClient mongoClient = new MongoClient(new ServerAddress(HOSTNAME, PORT), options);
		return mongoClient;
	}

	@Bean(name = MongoConstants.CUSTOMERDATABASE)
	public MongoDatabase mongoDatabase() {
		return getMongoClient().getDatabase(MongoConstants.CUSTOMERDATABASE);
	}

	@Bean(name = MongoConstants.CARSERVICEDATABASE)
	public MongoDatabase mongoCarServiceDB() {
		return getMongoClient().getDatabase(MongoConstants.CARSERVICEDATABASE);
	}
}
