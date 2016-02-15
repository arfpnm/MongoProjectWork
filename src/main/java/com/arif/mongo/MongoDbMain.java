package com.arif.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

/**
 * Hello world!
 *
 */
public class MongoDbMain 
{
    public static void main( String[] args )
    {
    	try(MongoClient mongoClient = new MongoClient("localhost",27017)){
	        
	        MongoDatabase mongoDatabase = mongoClient.getDatabase("travel");
	        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("travelcollection");
	        //Document query = new Document("origin.code","LAS");
	        //Document result = mongoCollection.find(query).first();
	        Bson destination = eq("destination.code","JFK");
	        Bson query = and(destination);
	        FindIterable<Document> results = mongoCollection.find(query);
	        
	        for(Document result : results){
	        	System.out.println(result.toJson());
	        }
	        
	        
	        
    	}
        
    }
}
