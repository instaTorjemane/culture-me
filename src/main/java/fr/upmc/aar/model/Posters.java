package fr.upmc.aar.model;

import com.google.gson.annotations.SerializedName;

/**
 * GSON class representing the movie poster links
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
public class Posters {
	
	@SerializedName("thumbnail")
	public String thumbnail;

	@SerializedName("profile")
	public String profile;

	@SerializedName("detailed")
	public String detailed;

	@SerializedName("original")
	public String original;


}
