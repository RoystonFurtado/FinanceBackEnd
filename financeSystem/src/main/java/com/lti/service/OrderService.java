package com.lti.service;

import com.lti.dao.GenericDao;
import com.lti.entity.Order;
import com.lti.entity.User;

public class OrderService implements Service {

	GenericDao dao = new GenericDao();
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		Order ord = (Order)dao.save(o);
		InstallmentService is = new InstallmentService();
		is.addInstallments(ord);
		
		
	}

	@Override
	public Object fetchByPk(Object o) {
		// TODO Auto-generated method stub
		return (Order)dao.fetchById(Order.class,o);
	}

}
