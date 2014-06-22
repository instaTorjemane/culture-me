package fr.upmc.aar.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.gson.annotations.SerializedName;

/**
 * Class representing the movie poster links
 * 
 **/
@PersistenceCapable
public class Posters {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key postersKey;
	
	@Persistent
	@SerializedName("thumbnail")
	private String thumbnail;

	@Persistent
	@SerializedName("profile")
	private String profile;

	@Persistent
	@SerializedName("detailed")
	private String detailed;

	@Persistent
	@SerializedName("original")
	private String original;
	
	
	public Key getPostersKey() {
		return postersKey;
	}

	public void setPostersKey(Key postersKey) {
		this.postersKey = postersKey;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDetailed() {
		return detailed;
	}

	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}
	
}
