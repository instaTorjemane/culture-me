package fr.upmc.aar.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.gson.annotations.SerializedName;

/**
 * Class representing the movie ratings
 * 
 **/
@PersistenceCapable
public class Rating {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key ratingKey;
	
	@Persistent
	@SerializedName("critics_rating")
	private String criticsRating;
	
	@Persistent
	@SerializedName("critics_score")
	private int criticsScore;

	@Persistent
	@SerializedName("audience_rating")
	private String audienceRating;

	@Persistent
	@SerializedName("audience_score")
	private int audienceScore;

	public String getCriticsRating() {
		return criticsRating;
	}

	public void setCriticsRating(String criticsRating) {
		this.criticsRating = criticsRating;
	}

	public int getCriticsScore() {
		return criticsScore;
	}

	public void setCriticsScore(int criticsScore) {
		this.criticsScore = criticsScore;
	}

	public String getAudienceRating() {
		return audienceRating;
	}

	public void setAudienceRating(String audienceRating) {
		this.audienceRating = audienceRating;
	}

	public int getAudienceScore() {
		return audienceScore;
	}

	public void setAudienceScore(int audienceScore) {
		this.audienceScore = audienceScore;
	}
	
}
