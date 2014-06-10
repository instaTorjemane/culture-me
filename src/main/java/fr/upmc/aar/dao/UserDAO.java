package fr.upmc.aar.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import fr.upmc.aar.model.User;

public class UserDAO {
	
	public static void addUser(User user){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(user);
		pm.close();
	}
	
	public static List<User> listUser(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(User.class);
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) q.execute();
		pm.close();
		return users;
	}

}
