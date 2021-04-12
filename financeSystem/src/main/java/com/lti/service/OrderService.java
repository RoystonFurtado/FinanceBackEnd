package com.lti.service;

import java.util.List;

import com.lti.dao.OrderDao;
import com.lti.entity.Order;

public class OrderService implements Service {

	OrderDao dao = new OrderDao();
	
	@Override
	public void add(Object o) {
		dao.save(o);
	}

	@Override
	public Object fetchByPk(Object o) {
		return (Order)dao.fetchById(Order.class,o);
	}
	
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
