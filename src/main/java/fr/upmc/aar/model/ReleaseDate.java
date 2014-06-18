package fr.upmc.aar.model;

import com.google.gson.annotations.SerializedName;

/**
 * GSON class representing the movie release dates
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
public class ReleaseDate {
	
	@SerializedName("theater")
	public String theater;
	
	@SerializedName("dvd")
	public String dvd;


}
