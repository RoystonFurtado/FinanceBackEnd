package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lti.entity.CardInfo;
import com.lti.entity.User;

public class UserCardDao extends GenericDao {

	@PersistenceContext
	EntityManager em;
	
	public List<User> fetchActiveAllGoldUsers() {
		String jpql = "select u from User u where u.emiCard.cardType ='Gold'";
		Query query = em.createQuery(jpql);
		List<User> list = query.getResultList();
		return list;
	}

	public List<User> fetchByUserName(String userName) { //Arguments
		String jpql = "select c from User c Where c.userName like :S";
		/* (javax.persistence) */Query query = em.createQuery(jpql);
		query.setParameter("S", "%" + userName + "%");
		List<User> list = query.getResultList();
		return list;
	}
	
	public List<User> fetchValidCard() { 
		String jpql = "select u from User u where u.cardInfo.cardExpiryDate >= :exp";
		Query query = em.createQuery(jpql);
		query.setParameter("exp", LocalDate.now());
		List<User> list = query.getResultList();
		return list; 
	}
}