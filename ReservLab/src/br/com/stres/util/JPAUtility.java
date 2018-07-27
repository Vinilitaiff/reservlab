package br.com.stres.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
	
	private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    
    public static EntityManagerFactory getEntityManagerFactory() {
          if (emf == null)
               emf = Persistence.createEntityManagerFactory("stremysql");
          return emf;
    }
     public static EntityManager getEntityManager() {
           if (em != null && em.isOpen())
                 return em;
           else {
                 em = getEntityManagerFactory().createEntityManager();
                 return em;
           }
     }
     
	
	/*
	private static final EntityManagerFactory emFactory;
	static {
		   emFactory = Persistence.createEntityManagerFactory("stresora");
	}
	public static EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
	public static void close(){
		emFactory.close();
	}*/
	

}
