package fr.upmc.aar.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import fr.upmc.aar.model.Comment;

public class CommentDAO {
	
	@SuppressWarnings("unchecked")
	public static List<Comment> userComments(String username){
		
		List<Comment> comments = null;
		
		if(UserDAO.userExists(username)){	
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(Comment.class);
			q.setFilter("username == userParameter");
			q.declareParameters("String userParameter");
			try{
				comments = (List<Comment>) q.execute(username);
			}catch(Exception e){
				System.out.println("Exception dans userComments");
			}finally{
				pm.close();
			}
		}else{
			System.out.println("Utilisateur non trouvé");
		}
		return comments;		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Comment> userMovieComment(String username, String movieTitle, String movieYear){
		
		List<Comment> comments = null;
		
		//if(UserDAO.userExists(username)){	
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(Comment.class);
			q.setFilter("username == userParameter && movieTitle == titleParameter && movieYear == yearParameter");
			q.declareParameters("String userParameter, String titleParameter, String yearParameter");
			try{
				comments = (List<Comment>) q.execute(username, movieTitle, movieYear);
			}catch(Exception e){
				System.out.println("Exception dans userComments");
			}finally{
				pm.close();
			}
//		}else{
//			System.out.println("Utilisateur non trouvé");
//		}
		return comments;		
	}
}
