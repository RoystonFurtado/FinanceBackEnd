package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.lti.entity.Installment;

@Component
public class InstallmentDao extends GenericDao{
	
	@PersistenceContext
	EntityManager em;
	
	public Installment fetchActiveInstallment(int id) {	
		String jpql="SELECT i FROM Installment i WHERE i.installmentStatus='Active' AND i.order.orderId=:oid";
		Query query=em.createQuery(jpql);
		query.setParameter("oid",id);
		Installment result=(Installment)query.getSingleResult();
		System.out.println(result);
		return result;
	}
	
	public Installment fetchNextInstallment(Installment currentInstallment) {
		String jpql="SELECT i FROM Installment i WHERE i.installmentNo=:ino AND i.order.orderId=:oid";
		Query query=em.createQuery(jpql);
		query.setParameter("oid",currentInstallment.getOrder().getOrderId());
		query.setParameter("ino",currentInstallment.getInstallmentNo()+1);
		Installment result=(Installment)query.getSingleResult();
		return result;
	}
}
