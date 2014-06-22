package fr.upmc.aar.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.datanucleus.FetchGroup;

import fr.upmc.aar.model.Movie;


public class MovieDAO {

	/*
	 * List of movies
	 */
	public static List<Movie> listMovies(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Movie.class);
		@SuppressWarnings("unchecked")
		List<Movie> movies = (List<Movie>) q.execute();
		pm.close();
		return movies;
	}

	public static void addMovie(Movie movie)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.getFetchPlan().setGroup(FetchGroup.ALL);

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
		pm.getFetchPlan().setGroup(FetchGroup.ALL);
		Query q = pm.newQuery(Movie.class);
		@SuppressWarnings("unchecked")
		List<Movie> movies = (List<Movie>) q.execute();
		pm.close();
		return movies;
	}


	/*
	 * Add comment to movie
	 */
	public static void addCommentToMovie(String title, String year, Comment comment){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Movie.class);
		Movie m = new Movie();
		
		List<Comment> allComments = getMovieComments(title, year);
		
		//Setter le commentaire dans l'objet movie
		m.setComments(allComments);
		
		//Persister
		try{
			pm.makePersistent(m);
		}catch(Exception e){
			System.out.println("Exception dans AddComment");	
		}finally{
			q.closeAll();
			pm.close();
		}
		System.out.println("Ajout du commentaire bien effectué");
	}
	
	/*
	 * get movie
	 */
	public static Movie getMovie(String title, String year){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Movie m = new Movie();
		Query q = pm.newQuery(Movie.class);
		q.setFilter("title = titleParameter && year == yearParameter");
		q.declareParameters("String titleParameter, String yearParameter");
		try{
			 m = (Movie) q.execute(title,year);
		}catch(Exception e){
			System.out.println("Exception dans getMovie()");
			e.printStackTrace();
		}finally{
			q.closeAll();
			pm.close();
		}
		return m;
		
	}


	/*get movies comments ==> A FAIRE DANS CommentsDAO 
	 */
	public static List<Comment> getMovieComments(String title, String year){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Movie.class);
		
		//Récupérer le film
		Movie m = getMovie(title, year);
		
		// Récupérer tout les commmentaires
		List<Comment> allComments = m.getComments();
		
		return allComments;
	}


	/*
	 * Check if product exists
	 */
	public static boolean movieExists(final String title)
	{
		boolean exists = false;
		
		@SuppressWarnings("unchecked")
		List<Movie> movies = (List<Movie>) PMF.get().getPersistenceManager().newQuery(Movie.class, "(title == '" + title + "')").execute();
		exists =  (movies!=null && movies.size() > 0);
		
		return exists;
	}
	
}
