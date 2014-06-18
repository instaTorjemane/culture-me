package fr.upmc.aar.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.gson.annotations.SerializedName;

/**
 * GSON class representing the cast character
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/

@PersistenceCapable
public class Character {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key CharacterKey;
	
	@Persistent
	@SerializedName("name")
	public String name;

	public Key getCharacterKey() {
		return CharacterKey;
	}

	public void setCharacterKey(Key characterKey) {
		CharacterKey = characterKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
