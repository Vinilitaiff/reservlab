package br.com.stres.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private  EntityManager em1 = Persistence.createEntityManagerFactory("stremysql").createEntityManager();

    public  EntityManager getEntityManager(){
        return em1;
    }
}
