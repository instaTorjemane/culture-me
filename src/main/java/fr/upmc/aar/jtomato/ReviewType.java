package fr.upmc.aar.jtomato;

/**
 * This is enum representing the possible review type. 3 different review types
 * are possible: "all", "top_critic" and "dvd". "top_critic" shows all the
 * Rotten Tomatoes designated top critics. "dvd" pulls the reviews given on the
 * DVD of the movie. "all" as the name implies retrieves all reviews.
 * 
 * 
 * @version 1.0
 * 
 * @see JTomato
 **/
public enum ReviewType {
	ALL("all"), TOP_CRITIC("top_critic"), DVD("dvd");

	private final String name;

	private ReviewType(String s) {
		name = s;
	}

	public String toString() {
		return name;
	}

}
