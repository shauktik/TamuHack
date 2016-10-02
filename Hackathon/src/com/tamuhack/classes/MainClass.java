package com.tamuhack.classes;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MainClass {
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		Mongo mongo = null;
		DB db = null;
		DBCollection table = null;
		try{ 
			mongo = new Mongo("localhost", 27017);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		db = mongo.getDB("testdb");
		table = db.getCollection("loginCredentials");
		
		table.drop();
		
		List<String> dbs = mongo.getDatabaseNames();
		
		for(String dbset:dbs){
			System.out.println(dbset);
		}
		
		db = mongo.getDB("testdb");
		Set<String> tables = db.getCollectionNames();
		
		for (String coll: tables){
			System.out.println(coll);
		}
		
		BasicDBObject basicDBObject = new BasicDBObject();
		
		db.createCollection("loginCredentials17", basicDBObject);
		
		
		BasicDBObject basicDBObject2 = new BasicDBObject();
		basicDBObject2.put("userName", "Shauktik");
		basicDBObject2.put("password", "Shauktik123");
		
		BasicDBObject basicDBObject3 = new BasicDBObject();
		basicDBObject3.put("userName", "Mayukh");
		basicDBObject3.put("password", "Mayukh123");
		
		db.getCollection("loginCredentials17").insert(basicDBObject2);
		db.getCollection("loginCredentials17").insert(basicDBObject3);
		
		System.out.println(db.getCollection("loginCredentials17").getCount());
		
		/*BasicDBObject searchQuery = new BasicDBObject();
		
		searchQuery.put("userName", "");
		searchQuery.put("password", "");
		DBCursor cursor = table.find(searchQuery);
		
		while (cursor.hasNext()){
			System.out.println(cursor.next());
		}*/
		
	}

}
