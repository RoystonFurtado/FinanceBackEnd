package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Installment;

public class InstallmentDao extends GenericDao{
	
	public Installment fetchActiveInstallment(int id) {	
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			String jpql="SELECT i FROM Installment i WHERE i.installmentStatus='Active' AND i.order.orderId=:oid";
			Query query=em.createQuery(jpql);
			query.setParameter("oid",id);
			Installment result=(Installment)query.getSingleResult();
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
	
	public Installment fetchNextInstallment(Installment currentInstallment) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			String jpql="SELECT i FROM Installment i WHERE i.installmentNo=:ino AND i.order.orderId=:oid";
			Query query=em.createQuery(jpql);
			query.setParameter("oid",currentInstallment.getOrder().getOrderId());
			query.setParameter("ino",currentInstallment.getInstallmentNo()+1);
			Installment result=(Installment)query.getSingleResult();
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
