package com.tamuhack.classes;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class LoginAuthentication {
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean authenticateUser(String userName, String password){
		
		this.userName = userName;
		this.password = password;
		
		MongoClient mongo = null;
		DB db = null;
		DBCollection table = null;
		try{ 
			mongo = new MongoClient("localhost", 27017);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		db = mongo.getDB("testdb");
		table = db.getCollection("loginCredentials17");
		
		BasicDBObject searchQuery = new BasicDBObject();
		
		searchQuery.append("userName", this.getUserName()).append("password", this.getPassword());
		//searchQuery.put("password", this.getPassword());
		
		DBObject obj = table.findOne(searchQuery);
	
		boolean setVal = false;
		
		if (obj!=null){
			System.out.println("In if");
			
				System.out.println("Object::"+obj.toString());
				setVal = true;
			
			
		}
		else{
			System.out.println("Else Block");
		}
	
		return setVal;
	}

	
	public static void main(String args[]){
		LoginAuthentication newTest = new LoginAuthentication();
		System.out.println(newTest.authenticateUser("Shauktik", "Shauktik123"));
		
	}
}
