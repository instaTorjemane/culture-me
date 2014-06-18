package fr.upmc.aar.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.gson.annotations.SerializedName;

/**
 * Class representing the movie release dates
 * 
 **/
@PersistenceCapable
public class ReleaseDate {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key realeaseDateKey;
	
	@Persistent
	@SerializedName("theater")
	private String theater;
	
	@Persistent
	@SerializedName("dvd")
	private String dvd;

	
	public Key getRealeaseDateKey() {
		return realeaseDateKey;
	}

	public void setRealeaseDateKey(Key realeaseDateKey) {
		this.realeaseDateKey = realeaseDateKey;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getDvd() {
		return dvd;
	}

	public void setDvd(String dvd) {
		this.dvd = dvd;
	}
	
}
