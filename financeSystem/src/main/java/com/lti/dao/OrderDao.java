package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Installment;
import com.lti.entity.Order;

public class OrderDao extends GenericDao {
	
	public List<Order> fetchAllActiveOrders() {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			String jpql="SELECT o FROM Order o WHERE o.orderStatus='Active'";
			Query query=em.createQuery(jpql);
			List<Order> result=query.getResultList();
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
	
	public List<Order> fetchOrdersByUser(int userId) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			String jpql="SELECT o FROM Order o WHERE o.user.userId=:id";
			Query query=em.createQuery(jpql);
			query.setParameter("id",userId);
			List<Order> result=query.getResultList();
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
