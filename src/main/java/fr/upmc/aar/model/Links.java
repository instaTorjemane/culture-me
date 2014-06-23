package fr.upmc.aar.model;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.gson.annotations.SerializedName;

/**
 * Class containing the movie links
 *
 **/
@PersistenceCapable
public class Links {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key linkKey;
	
	@Persistent
	@SerializedName("self")
	private String self;

	@Persistent
	@SerializedName("alternate")
	private String alternate;

	@Persistent
	@SerializedName("cast")
	private String cast;

	@Persistent
	@SerializedName("clips")
	private String clips;

	@Persistent
	@SerializedName("review")
	private String review;

	@Persistent
	@SerializedName("similar")
	private String similar;
	

	public Key getLinkKey() {
		return linkKey;
	}

	public void setLinkKey(Key linkKey) {
		this.linkKey = linkKey;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getAlternate() {
		return alternate;
	}

	public void setAlternate(String alternate) {
		this.alternate = alternate;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getClips() {
		return clips;
	}

	public void setClips(String clips) {
		this.clips = clips;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getSimilar() {
		return similar;
	}

	public void setSimilar(String similar) {
		this.similar = similar;
	}

	
}
