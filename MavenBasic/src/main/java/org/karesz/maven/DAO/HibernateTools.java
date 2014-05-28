package org.karesz.maven.DAO;

import java.util.List;

import org.hibernate.Session;


public class HibernateTools<T> {
	
	
	Class<T> clazz;
	
	
	public HibernateTools(Class<T> clazz) {
		//super();
		this.clazz = clazz;
	}




	public void addToDatabase(T cl){
		Session session = HibConfig.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(cl);
		session.getTransaction().commit();		
	}
	
	public void update(T cl){
		Session session = HibConfig.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(cl);
		session.getTransaction().commit();		
	}
	


	public T findById(int id){
		
		T var;
		Session session = HibConfig.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		var = (T)session.get(clazz, id);
		session.getTransaction().commit();			
		return var;
	}
	
	
	public List<T> findAll(){
		List<T> var;
		Session session = HibConfig.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		var = session.createCriteria(clazz).list();
		session.getTransaction().commit();			
		return var;		
	}
	
	public void delete(T var){
		Session session = HibConfig.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(var);
		session.getTransaction().commit();			
	}
	

}
