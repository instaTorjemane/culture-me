package fr.upmc.aar.model;

import com.google.gson.annotations.SerializedName;

/**
 * GSON class representing the movie ratings
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
public class Rating {

	@SerializedName("critics_rating")
	public String criticsRating;

	@SerializedName("critics_score")
	public int criticsScore;

	@SerializedName("audience_rating")
	public String audienceRating;

	@SerializedName("audience_score")
	public int audienceScore;
}
