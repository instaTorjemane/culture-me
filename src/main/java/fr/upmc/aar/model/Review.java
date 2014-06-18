package fr.upmc.aar.model;

import com.google.gson.annotations.SerializedName;

/**
 * GSON class representing the movie reviews
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
public class Review {

	@SerializedName("critic")
	public String critic;

	@SerializedName("date")
	public String date;

	@SerializedName("freshness")
	public String freshness;

	@SerializedName("publication")
	public String publication;

	@SerializedName("quote")
	public String quote;
}
