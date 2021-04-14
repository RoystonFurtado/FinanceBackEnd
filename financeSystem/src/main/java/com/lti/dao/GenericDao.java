package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component("genericDao")
public class GenericDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Object save(Object e) {
		Object obj=em.merge(e);
		return obj;
	}
	
	public Object fetchById(Class c1,Object id) {
		return em.find(c1,id);
	}
	
}
