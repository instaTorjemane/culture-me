package fr.upmc.aar.model;

import com.google.gson.annotations.SerializedName;

/**
 * GSON class containing the movie links
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
public class Links {

	@SerializedName("self")
	public String self;

	@SerializedName("alternate")
	public String alternate;

	@SerializedName("cast")
	public String cast;

	@SerializedName("clips")
	public String clips;

	@SerializedName("review")
	public String review;

	@SerializedName("similar")
	public String similar;

}
