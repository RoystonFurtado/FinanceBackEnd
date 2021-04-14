package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.lti.dao.GenericDao;
import com.lti.dao.OrderDao;
import com.lti.entity.Order;

@Component("orderService")
public class OrderService implements Service {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("app-config.xml");
	//OrderDao dao=(OrderDao)ctx.getBean("orderDao");
	
	@Autowired
	@Qualifier("orderDao")
	OrderDao dao;
	
	@Override
	@Transactional
	public void add(Object o) {
		dao.save(o);
	}

	@Override
	public Object fetchByPk(Object o) {
		return (Order)dao.fetchById(Order.class,o);
	}
	
	@Transactional
	public void addNewOrder(Object o) {
		Order ord = (Order)dao.save(o);
		InstallmentService is = new InstallmentService();
		is.addInstallments(ord);	
	}
	
	public List<Order> fetchAllActiveOrders() {
		return dao.fetchAllActiveOrders();
	}
	
	public List<Order> fetchOrdersByUser(int userId) {
		return dao.fetchOrdersByUser(userId);
	}

}
