package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class GenericDao {
	
	public Object save(Object e) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			Object obj=em.merge(e);
			tx.commit();
			return obj;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public Object fetchById(Class c1,Object id) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			Object obj = em.find(c1,id);
			return obj;
		}finally {
			em.close();
			emf.close();
		}
	}
	
}
