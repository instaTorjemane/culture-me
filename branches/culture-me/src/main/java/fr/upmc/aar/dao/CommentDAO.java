package fr.upmc.aar.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import fr.upmc.aar.model.Comment;

public class CommentDAO {
	
	@SuppressWarnings("unchecked")
	public static List<Comment> userComments(String username){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Comment> comments = null;
		Query q = pm.newQuery(Comment.class);
		q.setFilter("username = userParameter");
		q.declareParameters("String userParameter");
		try{
			comments = (List<Comment>) q.execute(username);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			q.closeAll();
			pm.close();
		}
		return comments;
	}

}
