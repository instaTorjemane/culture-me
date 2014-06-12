package fr.upmc.aar.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import fr.upmc.aar.model.User;

public class UserDAO {
	
	public static boolean addUser(User user)
	{
		boolean state = false;
		if(!userExists(user.getUsername())){
			PersistenceManager pm = PMF.get().getPersistenceManager();
	        try {
	            pm.makePersistent(user);
	            state = true;
	        } 
	        catch(Exception e){
	        	state =  false;
	        }
	        finally {
	            pm.close();
	        }
		}
		else{
			state = false;
		}
		return state;
	}
	
	public static List<User> listUser()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(User.class);
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) q.execute();
		pm.close();
		return users;
	}
	
	
	public static boolean userExists(final String username)
	{
		boolean exists = false;
		
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) PMF.get().getPersistenceManager().newQuery(User.class, "(username == '" + username + "')").execute();
		exists =  (users!=null && users.size() > 0);
		
		return exists;
	}

}
