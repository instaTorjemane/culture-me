package fr.upmc.aar.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.datanucleus.FetchGroup;

import fr.upmc.aar.model.Comment;
import fr.upmc.aar.model.Movie;


public class MovieDAO {

	/*
	 * List of movies
	 */
	public static List<Movie> listMovie(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Movie.class);
		@SuppressWarnings("unchecked")
		List<Movie> movies = (List<Movie>) q.execute();
		pm.close();
		return movies;
	}
	
	/*
	 * Add movie
	 */
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


	/*
	 * Add comment to movie
	 */
	public static void addCommentToMovie(String title, String year, Comment comment){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Movie.class);
		Movie m = new Movie();
		
		List<Comment> allComments = getMovieComments(title, year);
		if(allComments == null){
			allComments = new ArrayList<Comment>();
		}
		allComments.add(comment);
		
		//Setter le commentaire dans l'objet movie
		
		
		//Persister
		try{
			m.setComments(allComments);
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
	@SuppressWarnings("unchecked")
	public static Movie getMovie(String title, String year){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Movie m = new Movie();
		Query q = pm.newQuery(Movie.class);
		
		q.setFilter("title == titleParameter && year == yearParameter");
		q.declareParameters("String titleParameter, String yearParameter");
		
		try{
			 List<Movie> movies = (List<Movie>) q.execute(title,year);
			 if (movies != null && movies.size()==1){
				 m = movies.get(0);
			 }
		}catch(Exception e){
			System.out.println("Exception dans getMovie()");
			e.printStackTrace();
		}finally{
			q.closeAll();
			pm.close();
		}
		return m;
		
	}


	/*get movies comments
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
