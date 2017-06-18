package com.cisco.cmadt9blogger.data;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MorphiaService {
	
	private Morphia morphia;
	private Datastore datastore;
	
	public MorphiaService(){
		 
		//MongoClient mongoClient = new MongoClient("10.128.0.6:27017");
		//MongoClient mongoClient = new MongoClient("localhost:27017");
		MongoClient mongoClient = new MongoClient("192.168.99.100:27017");
		//create a new morphia instance
		this.morphia = new Morphia(); 
		String databaseName = "blogger";
		this.datastore = morphia.createDatastore(mongoClient, databaseName);
	}
	
	public Morphia getMorphia() {
		return morphia;
	}
 
	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}
 
	public Datastore getDatastore() {
		return datastore;
	}
 
	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}

}
