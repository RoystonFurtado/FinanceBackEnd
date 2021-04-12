package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class GenericDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Object save(Object e) {
		Object obj=em.merge(e);
		return obj;
	}
	
	public Object fetchById(Class c1,Object id) {
		return em.find(c1,id);
	}
	
}
