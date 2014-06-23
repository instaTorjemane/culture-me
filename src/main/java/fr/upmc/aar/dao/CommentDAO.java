package fr.upmc.aar.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import fr.upmc.aar.model.Comment;

public class CommentDAO {
	
	@SuppressWarnings("unchecked")
	public ResultState<List<Comment>> userComments(String username){
		
		ResultState<List<Comment>> comments = new ResultState<List<Comment>>();
		
		if(UserDAO.userExists(username)){	
			PersistenceManager pm = PMF.get().getPersistenceManager();
			comments.setState(true);
			Query q = pm.newQuery(Comment.class);
			q.setFilter("username = userParameter");
			q.declareParameters("String userParameter");
			try{
				List<Comment> coms = (List<Comment>) q.execute(username);
				comments.setContent(coms);
			}catch(Exception e){
				comments.setState(false);
			}finally{
				q.closeAll();
				pm.close();
			}
			
		}else{
			comments.setState(false);
		}
		return comments;
				
	}
		
		
}
