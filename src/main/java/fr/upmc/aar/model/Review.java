package fr.upmc.aar.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.gson.annotations.SerializedName;

/**
 * Class representing the movie reviews
 * 
 **/
public class Review {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key reviewKey;
	
	@Persistent
	@SerializedName("critic")
	private String critic;

	@Persistent
	@SerializedName("date")
	private String date;

	@Persistent
	@SerializedName("freshness")
	private String freshness;

	@Persistent
	@SerializedName("publication")
	private String publication;

	@Persistent
	@SerializedName("quote")
	private String quote;

	public Key getReviewKey() {
		return reviewKey;
	}

	public void setReviewKey(Key reviewKey) {
		this.reviewKey = reviewKey;
	}

	public String getCritic() {
		return critic;
	}

	public void setCritic(String critic) {
		this.critic = critic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFreshness() {
		return freshness;
	}

	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
}
