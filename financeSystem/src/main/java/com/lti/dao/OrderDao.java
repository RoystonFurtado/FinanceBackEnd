package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.lti.entity.Order;

@Component("orderDao")
public class OrderDao extends GenericDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Order> fetchAllActiveOrders() {
		String jpql="SELECT o FROM Order o WHERE o.orderStatus='Active'";
		Query query=em.createQuery(jpql);
		List<Order> result=query.getResultList();
		return result;	
	}
	
	public List<Order> fetchOrdersByUser(int userId) {
		String jpql="SELECT o FROM Order o WHERE o.user.userId=:id";
		Query query=em.createQuery(jpql);
		query.setParameter("id",userId);
		List<Order> result=query.getResultList();
		return result;	
	}
	
}
