package fr.upmc.aar.model;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.gson.annotations.SerializedName;

/**
 * GSON class representing the movie cast
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
@PersistenceCapable
public class AbridgedCast {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key abridgedKey;
	
	@Persistent
	@SerializedName("id")
	private String id;
	
	@Persistent
	@SerializedName("name")
	public String name;

	@Persistent
	@SerializedName("characters")
	private List<String> characters;

	public Key getAbridgedKey() {
		return abridgedKey;
	}

	public void setAbridgedKey(Key abridgedKey) {
		this.abridgedKey = abridgedKey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}
	
	

}
