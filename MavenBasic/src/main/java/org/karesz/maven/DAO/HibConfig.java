package org.karesz.maven.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibConfig {

	 private static final SessionFactory sessionFactory = buildSessionFactory();
	    private static ServiceRegistry serviceRegistry;

	    /**
	     * Generates session factory
	     * 
	     * @return SessionFactory
	     * 
	     */
	    
	    
	    private static SessionFactory buildSessionFactory() {
	        try {
	        	System.out.println("BUILD SESSION FACTORY");
	            Configuration config = new Configuration().configure();
	            System.out.println("1");
	            serviceRegistry =  new ServiceRegistryBuilder().applySettings(
						config.getProperties()).buildServiceRegistry();
	            System.out.println("2");

	            return config.buildSessionFactory(serviceRegistry);
	            
	        }
	        catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	    	System.out.println("3");
	    	
	        return sessionFactory;
	    }			
	
}
