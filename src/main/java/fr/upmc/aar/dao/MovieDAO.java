package fr.upmc.aar.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import fr.upmc.aar.model.Movie;

public class MovieDAO {

	/*
	 * Add Movie
	 */

	public static void addMovie(Movie movie)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			pm.makePersistent(movie);
		} 
		catch(Exception e){
		}
		finally {
			pm.close();
		}

	}
	
	public static List<Movie> listMovie()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Movie.class);
		@SuppressWarnings("unchecked")
		List<Movie> movies = (List<Movie>) q.execute();
		pm.close();
		return movies;
	}


	/*
	 * Add comment to product
	 */

	/*
	 * get product
	 */


	/*get product comments
	 * 
	 */



	/*
	 * List of products
	 */

	/*
	 * Check if product exists
	 */
}
