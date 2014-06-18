package fr.upmc.aar.dao;

import javax.jdo.PersistenceManager;

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
