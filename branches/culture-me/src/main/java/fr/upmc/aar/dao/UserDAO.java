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
				state = false;
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

	public static ResultState<List<User>> listUser()
	{
		ResultState<List<User>> result = new ResultState<List<User>>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Query q = pm.newQuery(User.class);
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) q.execute();
			result.setState(true);
			result.setContent(users);
		}
		catch(Exception e){
			result.setState(false);
			result.setContent(null);
		}
		finally{
			pm.close();
		}
		
		return result;
	}



	public static User getUser(String username, String password){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		User u = new User();
		Query q = pm.newQuery(User.class);
		//		List<User> users = (List<User>)pm.newQuery(User.class, "(username == '" + username + "'" + " && password == '" + password + "')").execute();
		//		
		//		if (users != null && users.size()==1)
		//			u = users.get(0);
		q.setFilter("username == userNameParameter && password == passwordParameter");
		q.declareParameters("String userNameParameter, String passwordParameter");
		try{
			List<User> users = (List<User>) q.execute(username,password);
			if (users != null && users.size()==1)
				u = users.get(0);	

		}catch(Exception e){
			System.out.println("Exception dans getUser()");
			e.printStackTrace();
		}finally{
			q.closeAll();
			pm.close();
		}
		return u;
	}


	public static boolean userExists(final String username)
	{
		boolean exists = false;

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) PMF.get().getPersistenceManager().newQuery(User.class, "(username == '" + username + "')").execute();
		exists =  (users!=null && users.size() > 0);

		return exists;
	}
	
	public static User getUserByMail(final String mail)
	{
		User u = null;

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) PMF.get().getPersistenceManager().newQuery(User.class, "(mail == '" + mail + "')").execute();
		if(users!=null && users.size() == 1){
			u = users.get(0);
		}
		return u;

	}

	public static ResultState<User> checkUser(final String username, final String password){
		ResultState<User> result = new ResultState<>();

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) PMF.get().getPersistenceManager().newQuery(User.class, "(username == '" + username + "')").execute();
		boolean state =  (users != null && users.size() == 1 && users.get(0) != null && password != null && users.get(0).getPassword().equals(password));

		result.setState(state);
		if(result.getState()){
			result.setContent(users.get(0));
		}
		else{
			result.setContent(null);
		}
		return result;
	}

}
