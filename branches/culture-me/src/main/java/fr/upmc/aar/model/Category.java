package fr.upmc.aar.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Category {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key keyCategory;
	
	@Persistent
	private String name;


	/*
	 * GET/SET
	 */
	
	public Key getKeyCategory() {
		return keyCategory;
	}

	public void setKeyCategory(Key keyCategory) {
		this.keyCategory = keyCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	
}
