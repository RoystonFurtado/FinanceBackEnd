package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.lti.entity.Product;

@Component
public class ProductDao extends GenericDao{
	
	@PersistenceContext
	EntityManager em;
	
	public Product fetchByProductPrice(double price) {	
		String jpql="SELECT p FROM Product p WHERE p.productPrice=:price";
		Query query=em.createQuery(jpql);
		query.setParameter("price",price);
		Product result=(Product)query.getSingleResult();
		System.out.println(result);
		return result;
	}

}
