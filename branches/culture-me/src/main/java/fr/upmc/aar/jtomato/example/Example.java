package fr.upmc.aar.jtomato.example;

import fr.upmc.aar.jtomato.JTomato;
import fr.upmc.aar.model.Movie;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This is simple example of JTomato
 **/
public class Example {

	public static void main(String[] args) {
		// Creating a JTomato instance, you need a valid API key.
		JTomato jtomato = new JTomato("nmmu57pre35rzzvhbvdjetts");
		
		//setting the number of results per page. Default is 30.
		jtomato.setPage_limit(50);

		// Creating a list to store the results
		List<Movie> movies = new ArrayList<Movie>();
		
		movies = jtomato.getBoxOfficeMovies("us", 50);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println("LISTE DES MOVIES DU JSON");
		for(Movie m : movies){
			System.out.println(m.getTitle());
			System.out.println();
			System.out.println(m.getSynopsis());
			System.out.println();
			System.out.println(m.getYear());
			//System.out.println(gson.toJson(m));
		}
		
		// Searching a movie, page 1
		//int total = jtomato.searchMovie("spider man", movies, 1);
		//System.out.println("Found " + total + " results");
		System.out.println("First result: " + gson.toJson(movies.get(0)));
		
		// Obtaining additional info
		Movie movie = jtomato.getMovieAdditionalInfo(movies.get(0));
		// Printing the movie genre
		System.out.println("Movie genre: "+movie.getGenres().get(0));

		// Getting similar movies
		try{
			List<Movie> similarMovies = jtomato.getSimilarMovies(movie, "us", 5);
			System.out.println("A similar movie: " + similarMovies.get(0));
		}
		catch(Exception e){
			System.out.println("No similar found");
		}

	}

}
