package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.lti.entity.User;

@Component("userDao")
public class UserDao extends GenericDao {

	@PersistenceContext
	EntityManager em;
	
	public List<User> fetchAllActiveGoldUsers() {
		String jpql = "select u from User u where u.emiCard.cardType ='Gold' AND u.profile_status='Active'";
		Query query = em.createQuery(jpql);
		List<User> list = query.getResultList();
		return list;
	}

	public List<User> fetchUsersByName(String userName) { //Arguments
		String jpql = "select c from User c Where c.userName like :S";
		/* (javax.persistence) */Query query = em.createQuery(jpql);
		query.setParameter("S", "%" + userName + "%");
		List<User> list = query.getResultList();
		return list;
	}
	
	public List<User> fetchValidCards() { 
		String jpql = "select u from User u where u.cardInfo.cardExpiryDate >= :exp";
		Query query = em.createQuery(jpql);
		query.setParameter("exp", LocalDate.now());
		List<User> list = query.getResultList();
		return list; 
	}
}