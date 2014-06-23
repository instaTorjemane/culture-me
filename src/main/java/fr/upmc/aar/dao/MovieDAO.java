package fr.upmc.aar.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import com.google.appengine.api.datastore.Key;

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
	public static boolean addMovie(Movie movie)
	{
		boolean state;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(movie);
			state = true;
		} 
		catch(Exception e){
			state = false;
		}
		finally {
			pm.close();
		}
		return state;

	}


	/*
	 * Add comment to movie
	 */
	public static void addCommentToMovie(String title, String year, Comment comment){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Movie m = null;
		
		//Déclaration de notre requête sur l'entité Movie
		Query q = pm.newQuery(Movie.class);
		
		//Déclaration des paramètres et filtrage de la requête
		q.setFilter("title == titleParameter && year == yearParameter");
		q.declareParameters("String titleParameter, String yearParameter");
		
		
		//Persister
		try{

			
			List<Movie> movies = (List<Movie>) q.execute(title,year);
			if (movies != null && movies.size()==1){
				//Récupération du film
				m = movies.get(0);
				//Récupération des commentaires du films
				List<Comment> allComments = m.getComments();
				if(allComments == null){
					allComments = new ArrayList<Comment>();
				}
				//Ajout du commentaire
				allComments.add(comment);
				
				//Setter le commentaire dans l'objet movie
				m.setComments(allComments);
				//pm.makePersistent(m);
			}
			
			}catch(Exception e){
				System.out.println("Exception dans AddComment");	
			}finally{
				//q.closeAll();
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
			Movie m = null;
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

		/*
		 * get movie
		 */
		@SuppressWarnings("unchecked")
		public static Key getMovieKey(String title, String year){
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
			return m.getMovieKey();		
		}



		/*get movies comments
		 */
		public static List<Comment> getMovieComments(String title, String year){
			List<Comment> comments = null;
			Movie m = getMovie(title, year);
			if(m != null ){
				comments = m.getComments();
			}
			return comments;
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
