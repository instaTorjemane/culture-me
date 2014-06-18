package fr.upmc.aar.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * GSON class representing the movie cast
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
public class AbridgedCast {
	
	@SerializedName("id")
	public String id;
	
	@SerializedName("name")
	public String name;

	@SerializedName("characters")
	public List<String> characters;

}
