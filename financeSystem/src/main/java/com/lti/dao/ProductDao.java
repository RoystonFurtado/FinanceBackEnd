package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Installment;
import com.lti.entity.Product;

public class ProductDao {
	public Product fetchByProductPrice(double price) {	
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			String jpql="SELECT p FROM Product p WHERE p.productPrice=:price";
			Query query=em.createQuery(jpql);
			query.setParameter("price",price);
			Product result=(Product)query.getSingleResult();
			System.out.println(result);
			return result;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			em.close();
			emf.close();
		}
	}

}
