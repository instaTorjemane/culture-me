package fr.upmc.aar.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;


public class PMF 
{
	private static final PersistenceManagerFactory pmfInstance =
	        JDOHelper.getPersistenceManagerFactory("transactions-optional");

	    private PMF() {}

	    public synchronized static PersistenceManagerFactory get() {
	        return pmfInstance;
	    }


}
