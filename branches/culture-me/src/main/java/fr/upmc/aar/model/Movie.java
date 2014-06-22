package fr.upmc.aar.model;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.gson.annotations.SerializedName;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * GSON class representing a movie
 **/

@PersistenceCapable
public class Movie {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key movieKey;
	
	@Persistent
	@SerializedName("id")
	private String id;

	@Persistent
	@SerializedName("title")
	private String title;

	@Persistent
	@SerializedName("genres")
	private List<String> genres;

	// Cannot be int because API sometimes return an emptystring ""
	@Persistent
	@SerializedName("year")
	private String year;

	@Persistent
	@SerializedName("mpaa_rating")
	private String mpaaRating;

	@Persistent
	@SerializedName("ratings")
	private Rating rating;

	@Persistent
	@SerializedName("release_dates")
	private ReleaseDate releaseDate;

	// Cannot be int because API sometimes return an emptystring ""
	@Persistent
	@SerializedName("runtime")
	private String runtime;

	@Persistent
	@SerializedName("critics_consensus")
	private String criticsConsensus;

	@Persistent
	@SerializedName("synopsis")
	private String synopsis;

	@Persistent
	@Embedded
	@SerializedName("posters")
	public Posters posters;

	@Persistent
	@SerializedName("links")
	private Links links;

	@Persistent
	@SerializedName("abridged_cast")
	private List<AbridgedCast> abridgedCast;
	
	@Persistent
	private List<Comment> comments;

	public Key getMovieKey() {
		return movieKey;
	}

	public void setMovieKey(Key movieKey) {
		this.movieKey = movieKey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMpaaRating() {
		return mpaaRating;
	}

	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public ReleaseDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(ReleaseDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getCriticsConsensus() {
		return criticsConsensus;
	}

	public void setCriticsConsensus(String criticsConsensus) {
		this.criticsConsensus = criticsConsensus;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Posters getPosters() {
		return posters;
	}

	public void setPosters(Posters posters) {
		this.posters = posters;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public List<AbridgedCast> getAbridgedCast() {
		return abridgedCast;
	}

	public void setAbridgedCast(List<AbridgedCast> abridgedCast) {
		this.abridgedCast = abridgedCast;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}