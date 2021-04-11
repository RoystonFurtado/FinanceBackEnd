package com.lti.service;

import com.lti.dao.GenericDao;
import com.lti.entity.Order;
import com.lti.entity.User;

public class OrderService implements Service {

	GenericDao dao = new GenericDao();
	
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

}
