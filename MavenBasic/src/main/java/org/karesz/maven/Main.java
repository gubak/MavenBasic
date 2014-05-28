package org.karesz.maven;

import org.karesz.maven.DAO.HibernateTools;
import org.karesz.maven.model.Bicycle;



public class Main {

	public static void main(String[] args) {
		System.out.println("Start");

		Bicycle bicycle = new Bicycle();
		bicycle.setName("BRINGA");
		
		
		HibernateTools<Bicycle> kara = new HibernateTools<Bicycle>(Bicycle.class);
		kara.addToDatabase(bicycle);			
		
		System.out.println("Stop");

	}

}
