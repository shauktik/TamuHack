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
		table = db.getCollection("testColl");
		
		table.drop();
		
		List<String> dbs = mongo.getDatabaseNames();
		
		for(String dbset:dbs){
			System.out.println(dbset);
		}
		
		db = mongo.getDB("local");
		Set<String> tables = db.getCollectionNames();
		
		for (String coll: tables){
			System.out.println(coll);
		}
		
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("name", "Shauktik");
		basicDBObject.put("Age", "27");
		
		BasicDBObject basicDBObject2 = new BasicDBObject();
		basicDBObject.put("name", "Mayukh");
		basicDBObject.put("Age", "27");
		
		table.insert(basicDBObject);
		table.insert(basicDBObject2);
		
		BasicDBObject searchQuery = new BasicDBObject();
		DBCursor cursor = table.find(searchQuery);
		
		while (cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
	}

}
